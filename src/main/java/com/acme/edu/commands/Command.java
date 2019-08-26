package com.acme.edu.commands;

public interface Command {
    String getDecorated();
    boolean isTypeEqual(Command command);
    void accumulate(Command command);
    boolean isSaveRequired(Command command);
}
