package com.acme.edu.controller;

import com.acme.edu.commands.Command;

public interface Controller {

    public void log(Command command) throws RuntimeException;

    public void flush();
    public void flushUnsafe() throws Exception;

    public default void close() throws Exception {

    }


}
