package com.acme.edu.commands;

public interface Command {
    String getDecorated();
    boolean isTypeEqual(Command command);
    Command accumulate(Command command);
    boolean isSaveRequired(Command command);
}
