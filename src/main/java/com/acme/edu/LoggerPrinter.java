package com.acme.edu;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by eugene on 03.11.15.
 */
public class LoggerPrinter implements Closeable {
    public LoggerPrinter() throws IOException {
    }

    void print(String s) {}

    @Override
    public void close() throws IOException {
        throw new IOException("fff");
    }
}
