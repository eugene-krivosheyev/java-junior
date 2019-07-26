package com.acme.edu.saver;

import java.io.IOException;

public abstract class Saver {
    public abstract void save(String message) throws IOException;

    public abstract void close() throws IOException;
}
