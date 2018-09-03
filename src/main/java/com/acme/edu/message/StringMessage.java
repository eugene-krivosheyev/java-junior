package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class StringMessage extends Message {
    private String message;
    private Collection<String> collection;

    public String getMessage() {
        return message;
    }

    public int getCountOfStrings() {
        return collection.stream()
                .map(e -> 1)
                .reduce(0, (e1, e2) -> e1+e2);
    }

    public Collection getCollection() {
        return collection;
    }

    public StringMessage(String message) {
        this(message, Arrays.asList(message));
    }

    public StringMessage(String message, Collection collection) {
        this.message = message;
        this.collection = collection;
    }

    @Override
    public Message accumulate(Message message) {
        //return new StringMessage(this.message, this.countOfStrings + ((StringMessage) message).getCountOfStrings());
        Collection concatenateCollection = new ArrayList();
        concatenateCollection.addAll(this.getCollection());
        concatenateCollection.addAll(((StringMessage) message).getCollection());
        return new StringMessage(this.message, concatenateCollection);
    }

    @Override
    public String decorate(Map<MessageType, Decorator> decoratorMap) {
        return decorate(decoratorMap.get(MessageType.STRING));
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return message instanceof StringMessage && ((StringMessage) message).getMessage().equals(this.message);
    }
}
