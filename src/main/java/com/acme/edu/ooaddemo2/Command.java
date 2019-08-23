package com.acme.edu.ooaddemo2;

public interface Command {
    int getSeverity();
    String getDecorated();
    boolean isTypeEquals(Command previous);
    Command accumulate(Command other);
    Object getDta();
}
