package com.acme.edu.command;

import com.acme.edu.saver.ConsoleLoggerSaver;

import java.io.IOException;

public interface Command {
    void accumulate(Command accumulator, ConsoleLoggerSaver saver) throws IOException;
    void flush() throws IOException;
    Command getPrevCommand();
    String messageDecorate();
}
