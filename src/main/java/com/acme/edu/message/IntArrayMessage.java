package com.acme.edu.message;

public class IntArrayMessage implements Message {
    private int [] message;

    public IntArrayMessage (int [] message) {
        this.message = message;
    }

    @Override
    public Message accumulate(Message nextMessage) {
        return null;
    }

    @Override
    public String getDecoratedMessage() {
        return "primitives array" + ": " + oneDimArrayAsString() + System.lineSeparator();
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }

    protected String oneDimArrayAsString() {
        if (message.length == 0) {
            return "{" + System.lineSeparator() + "}";
        }
        StringBuilder arrayAsString = new StringBuilder("{");
        for (int i = 0; i < message.length - 1; i++) {
            arrayAsString.append(message[i]);
            arrayAsString.append(", ");
        }
        arrayAsString.append(message[message.length - 1]);
        arrayAsString.append("}");
        return arrayAsString.toString();
    }
}
