package com.acme.edu.mylogger;

public interface Command {
    Command accumulate(Command other);
    String getDecorated();
    Object getMessage();
    boolean isTypeEquals(Command previous);
    boolean isOverflow();
}
