package com.acme.edu.command;

import com.acme.edu.saver.Saver;

public interface CommandMessage {
    void flush(Saver saver);
    void update(CommandMessage command, Saver saver);
    String primitiveDecorator();
}
