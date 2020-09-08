package com.acme.edu.command;

public interface Command {

    String toString();

    String decorate();

    boolean isSameType(Command cmd);

    Command reduce(Command cmd);
}
