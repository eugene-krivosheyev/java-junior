package com.db.edu;

public class StringBuffer {
    private int quantityString = 0;
    private String bufString = null;

    void accumulate(String message) {
        ++quantityString;
        bufString = message;
    }

    public String getBufString() {
        return bufString;
    }

    public int getQuantityString() {
        return quantityString;
    }

    public void bufferFlush() {
        quantityString = 0;
        bufString = null;
    }
}
