package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.BinaryOperator;

public class IntMessage extends Message {
    private int message;
    private Collection<Integer> collection;

    public int getMessage() {
        class IntCollectionOverflowException extends RuntimeException {
            private int index;
            private int currentSum;

            public IntCollectionOverflowException(int index, int currentSum) {
                this.index = index;
                this.currentSum = currentSum;
            }

            public int getIndex() {
                return index;
            }

            public int getCurrentSum() {
                return currentSum;
            }
        }
        try {
            int result = collection.stream()
                    .reduce(0, new BinaryOperator() {
                        private int iteration = 0;

                        @Override
                        public Object apply(Object o, Object o2) {
                            Integer i1 = (Integer) o;
                            Integer i2 = (Integer) o2;
                            iteration++;
                            if (!isOverflow(i1, i2)) {
                                return i1 + i2;
                            } else {
                                throw new IntCollectionOverflowException(iteration, i1);
                            }
                        }
                    });
            return result;
        } catch (IntCollectionOverflowException e) {
            this.collection = ((ArrayList)this.collection).subList(e.getIndex()-1,this.collection.size());
            return e.getCurrentSum();
        }
    }

    public Collection getCollection() {
        return collection;
    }

    public IntMessage(int message) {
        this(message, Arrays.asList(message));
    }

    public IntMessage(int message, Collection collection) {
        this.message = message;
        this.collection = collection;
    }

    @Override
    public Message accumulate(Message message) {
        Collection concatenateCollection = new ArrayList();
        concatenateCollection.addAll(this.getCollection());
        concatenateCollection.addAll(((IntMessage) message).getCollection());
        return new IntMessage(this.message, concatenateCollection);
    }

    @Override
    public String decorate(Map<MessageType, Decorator> decoratorMap) {
        return decorate(decoratorMap.get(MessageType.INT));
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return message instanceof IntMessage && !isOverflow(this.message, ((IntMessage) message).message);
    }

    private boolean isOverflow(int val1, int val2) {
        return val1 > 0 ?
                Integer.MAX_VALUE - val1 < val2 :
                Integer.MIN_VALUE - val1 > val2;
    }
}
