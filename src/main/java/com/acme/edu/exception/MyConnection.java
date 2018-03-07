package com.acme.edu.exception;

import java.io.Closeable;
import java.io.IOException;

public class MyConnection implements Closeable {
    @Override
    public void close() throws IOException {

    }
}
