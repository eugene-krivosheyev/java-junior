package com.acme.edu.message;

import com.acme.edu.decorators.Decorator;

import java.util.ArrayList;
import java.util.Collection;

public class IntMessage implements Message {
    private Collection<Integer> values;
    private Decorator decorator;

    public Collection<Integer> getValues() {
        return values;
    }

    public IntMessage(int value, Decorator decorator) {
        this.decorator = decorator;
        this.values = new ArrayList<>();
        this.values.add(value);
    }

    public IntMessage(Collection<Integer> values, Decorator decorator) {
        this.values = values;
        this.decorator = decorator;
    }

    @Override
    public String decorate() {
        return decorator.decorate("" + this.aggregate());
    }

    private Integer aggregate() {
        return this.values.stream()
                .reduce((e1, e2) -> e1 + e2)
                .get();
    }

    @Override
    public Message accumulate(Message message) {
        this.values.addAll(((IntMessage) message).getValues());
        return this;
    }

    @Override
    public boolean isSameType(Message message) {
        if (message == null) return false;
        return message instanceof IntMessage;
    }
}
