package com.acme.edu.commands;

import com.acme.edu.CommandAndFlushOptional;

/**
 * Created by kate-c on 23/08/2019.
 */
public interface Command {
    Object getMessage();
    void setMessage(Object message);
    CommandAndFlushOptional accumulate(Command command);
    String decorate();
    boolean isTypeEqual(Command other);
}
