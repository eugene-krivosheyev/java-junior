package com.acme.edu.message;

public class ArrayMessage implements Message {
    private int[] value;
    private static  String prefix = "primitives array: ";

    public ArrayMessage(int[] value) {
        this.value = value;
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof ArrayMessage;
    }

    @Override
    public void updateAccumulator(Message message) {
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public boolean needFlush(Message message) {
        return false;
    }

    private static  String getStringFromArray(int [] arr) {
        StringBuilder strForPrint = new StringBuilder("{");
        for (int i = 0; i < arr.length; i++) {
            strForPrint.append(arr[i]);
            if (i < arr.length -1) { strForPrint.append(", ");}
        }
        strForPrint.append("}");
        return strForPrint.toString();
    }

    @Override
    public String toString() {
        String strForPrint = getStringFromArray(value);
        return prefix + strForPrint;
    }
}
