package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class ByteMessage extends Message {
    private byte message;
    private Collection<Byte> collection;

    public byte getMessage() {
        return collection.stream()
                .reduce((byte) 0, (e1, e2) -> (byte)(e1+e2));
    }

    public Collection getCollection() {
        return collection;
    }

    public ByteMessage(byte message) {
        this(message, Arrays.asList(message));
    }

    public ByteMessage(byte message, Collection collection) {
        this.message = message;
        this.collection = collection;
    }

    @Override
    public Message accumulate(Message message) {
        Collection concatenateCollection = new ArrayList();
        concatenateCollection.addAll(this.getCollection());
        concatenateCollection.addAll(((ByteMessage) message).getCollection());
        return new ByteMessage(this.message, concatenateCollection);
    }

    @Override
    public String decorate(Map<MessageType, Decorator> decoratorMap) {
        return decorate(decoratorMap.get(MessageType.BYTE));
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return message instanceof ByteMessage && !isOverflow(this.message, ((ByteMessage) message).message);
    }

    private boolean isOverflow(byte val1, byte val2) {
        return val1 > 0 ?
                Byte.MAX_VALUE - val1 < val2 :
                Byte.MIN_VALUE - val1 > val2;
    }
}
