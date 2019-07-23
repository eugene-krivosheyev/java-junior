package com.acme.edu.command;

import com.acme.edu.exceptions.MaxValueReachedException;
import com.acme.edu.saver.Saver;

public interface CommandMessage {
    void flush(Saver saver);
    void update(CommandMessage command, Saver saver) throws MaxValueReachedException;
    String primitiveDecorator();
}
