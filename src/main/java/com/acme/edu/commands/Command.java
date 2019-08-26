package com.acme.edu.commands;

public interface Command {
    String getDecorated();
    boolean isTypeEquals(Command other);
    Command accumulate(Command other);
}
