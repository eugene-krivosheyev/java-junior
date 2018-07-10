package com.acme.edu;

import com.acme.edu.Saver.Saver;

public class LogWorker {
    private Saver saver;

    private int intBuffer;

    LogWorker(Saver saver) {
        this.saver = saver;
    }

    public void setSaver(Saver saver) {
        this.saver = saver;
    }

    public void log(int message) {
        if (message != 0) {
            intBuffer += message;
        } else {
            saver.save("primitive: " + message);
        }

    }

    public void log(byte message) {
        flushIntegerBuffer();
        saver.save("primitive: " + message);
    }

    public void log(char message) {
        flushIntegerBuffer();
        saver.save("char: " + message);
    }

    public void log(String message) {
        flushIntegerBuffer();
        saver.save("string: " + message);
    }

    public void log(boolean message) {
        flushIntegerBuffer();
        saver.save("primitive: " + message);
    }

    public void log(Object message) {
        flushIntegerBuffer();
        saver.save("reference: " + message);
    }

    public void flushIntegerBuffer() {
        if (intBuffer != 0) {
            saver.save("primitive: " + intBuffer);
            intBuffer = 0;
        }
    }
}
