package com.acme.edu;

/**
 * Created by kate-c on 23/08/2019.
 */
public interface Command {
    Object getMessage();
    void setMessage(Object message);
    MayBeFlushableCommand accumulate(Command command);
    String decorate();
    boolean isTypeEqual(Command other);
}
