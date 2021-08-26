package com.db.edu;

public class StringBuffer {
    private int quantityString = 0;
    private String bufString = null;

    void accumulate(String message) {
        ++quantityString;
        bufString = message;
    }

    String getBufString() {
        return bufString;
    }

    int getQuantityString() {
        return quantityString;
    }

    void bufferFlush() {
        quantityString = 0;
        bufString = null;
    }

    boolean isEmpty() {
        return quantityString == 0;
    }

    boolean isStringEquals(String string) {
        return string.equals(bufString);
    }
}
