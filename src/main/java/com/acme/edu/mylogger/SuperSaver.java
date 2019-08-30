package com.acme.edu.mylogger;

import java.io.IOException;

public interface SuperSaver {
    void save(String message) throws IOException;
}
