package com.acme.edu.command;

import com.acme.edu.saver.ConsoleLoggerSaver;
import com.acme.edu.saver.Saver;

import java.io.IOException;

public interface Command {
    void accumulate(Command accumulator, Saver saver) throws IOException;
    void flush() throws IOException;
    Command getPrevCommand();
    String messageDecorate();
}
