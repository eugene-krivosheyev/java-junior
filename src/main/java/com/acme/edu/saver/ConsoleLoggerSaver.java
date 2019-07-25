package com.acme.edu.saver;

import java.io.IOException;

public class ConsoleLoggerSaver extends Saver {
    public void save(String message) throws IOException {
        System.out.println(message);
    }

    @Override
    public void close() throws IOException {

    }
}
