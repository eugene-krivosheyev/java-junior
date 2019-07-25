package com.acme.edu.saver;

import java.io.IOException;

public interface Saver {
    void save(String message) throws IOException;
    void newLog() throws IOException;

    void delete() throws IOException;
}
