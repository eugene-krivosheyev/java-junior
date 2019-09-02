package com.acme.edu.mylogger.savers;

import java.io.IOException;

public interface SuperSaver {
    void save(String message) throws IOException;
}
