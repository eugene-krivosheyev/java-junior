package com.acme.edu.saver;

import java.io.IOException;

public interface LoggerSaver {
    void save(String representation) throws SaveException;

    class SaveException extends IOException {
    }
}


