package com.acme.logger;

public interface LoggerSaver {
    void save(String message) throws SavingException;
}
