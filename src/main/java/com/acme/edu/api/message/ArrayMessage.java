package com.acme.edu.api.message;

public abstract class ArrayMessage extends Message {
    private boolean isPrintAsArray;

    public void setPrintAsArray(boolean toggle) {
        isPrintAsArray = toggle;
    }

    public boolean getPrintAsArray() {
        return isPrintAsArray;
    }

    @Override
    public String getMessageAsString() {
        if (getPrintAsArray()) {
            return super.getMessageAsString();
        }
        return streamCount();
    }

    abstract String streamCount();

    String makeTheString(int[] array) {
        StringBuilder arrayToString = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                arrayToString.append("{");
            }
            arrayToString.append(array[i]);
            if (i != array.length - 1) {
                arrayToString.append(", ");
            } else {
                arrayToString.append("}");
            }
        }
        return (arrayToString.toString());
    }
}
