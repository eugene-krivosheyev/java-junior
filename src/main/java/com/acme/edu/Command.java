package com.acme.edu;

public interface Command {
    Command accumulate(Command other);
    String getDecorated();
    Object getMessage();
    boolean isTypeEquals(Command previous);
    boolean isOverflow();
}
