package com.acme.edu.message;

public class Int2DimArrayMessage implements Message {
    IntArrayMessage[] message;

    public Int2DimArrayMessage(int[][] message) {
        this.message = new IntArrayMessage[message.length];
        for (int i = 0; i < this.message.length; i++) {
            this.message[i] = new IntArrayMessage(message[i]);
        }
    }

    @Override
    public Message accumulate(Message nextMessage) {
        return null;
    }

    @Override
    public String getDecoratedMessage() {
        String[] arrayOfIntsAsString = new String[message.length];
        for (int i = 0; i < message.length; i++) {
            arrayOfIntsAsString[i] = message[i].oneDimArrayAsString();
        }
        String joinedArraysAsStrings = String.join(System.lineSeparator(), arrayOfIntsAsString);
        String finalResult = "primitives matrix: "+"{" + System.lineSeparator() +
                joinedArraysAsStrings + System.lineSeparator() + "}";
        return finalResult;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }
}
