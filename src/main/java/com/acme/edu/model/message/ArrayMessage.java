package com.acme.edu.model.message;

public class ArrayMessage extends UnableToJoinMessage {
    private final int[] values;

    public ArrayMessage(int[] values) {
        this.values = values;
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
    public int[] getBody() {
        return values;
    }
}
