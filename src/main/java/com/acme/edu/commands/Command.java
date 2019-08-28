package com.acme.edu.commands;

public interface Command {
    String PRIMITIVE_PREFIX = "primitive: ";

    String getDecorated();

    boolean isTypeEquals(Command other);

    Command accumulate(Command other);

    Object getMessage();
}
