package com.acme.edu.command;

import com.acme.edu.exceptions.MaxValueReachedException;
import com.acme.edu.saver.Saver;

import java.io.IOException;

public interface CommandMessage {
    void flush(Saver saver) throws IOException;
    void update(CommandMessage command, Saver saver) throws MaxValueReachedException, IOException;
    String primitiveDecorator();
}
