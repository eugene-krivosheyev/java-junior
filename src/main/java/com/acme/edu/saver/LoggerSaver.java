package com.acme.edu.saver;

import java.util.Objects;

public abstract class LoggerSaver implements Saver {
    @Override
    public void save(String message) {
        if (Objects.isNull(message)) return;
        saveOp(message);
    }

    protected abstract void saveOp(String message);
}
