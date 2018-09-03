package com.acme.edu.message;

import com.acme.edu.decorators.Decorator;

import java.util.ArrayList;
import java.util.Collection;

public class ByteMessage implements Message {
    private Collection<Byte> values;
    private Decorator decorator;

    public Collection<Byte> getValues() {
        return values;
    }

    public ByteMessage(byte value, Decorator decorator) {
        this.decorator = decorator;
        this.values = new ArrayList<>();
        this.values.add(value);
    }

    public ByteMessage(Collection<Byte> values, Decorator decorator) {
        this.values = values;
        this.decorator = decorator;
    }

    @Override
    public String decorate() {
        return decorator.decorate("" + this.aggregate());
    }

    private Byte aggregate() {
        return this.values.stream()
                .reduce((e1, e2) -> (byte) (e1 + e2))
                .get();
    }

    @Override
    public Message accumulate(Message message) {
        this.values.addAll(((ByteMessage) message).getValues());
        return this;
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof ByteMessage;
    }
}
