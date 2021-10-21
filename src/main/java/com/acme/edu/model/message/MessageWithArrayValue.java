package com.acme.edu.model.message;

public class MessageWithArrayValue implements Message {
    private final int[] values;

    public MessageWithArrayValue(int[] values) {
        this.values = values;
    }

    @Override
    public Message getJoinedMessage(Message message) {
        throw new IllegalStateException();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("primitives array: {");
        for (int i = 0; i < values.length; i++) {
            stringBuilder.append(values[i]);
            if (i != values.length - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public boolean canJoinMessage(Message message) {

        return false;
    }
}
