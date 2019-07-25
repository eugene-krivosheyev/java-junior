package com.acme.edu.saver;

import java.io.IOException;

public class ConsoleSaver implements Saver {

    @Override
    public void save(String message) {
        System.out.print(message);
    }

    @Override
    public void newLog() throws IOException {

    }

    @Override
    public void delete() throws IOException {

    }
}
