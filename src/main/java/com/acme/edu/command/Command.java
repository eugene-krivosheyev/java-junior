package com.acme.edu.command;

import com.acme.edu.Type;
import com.acme.edu.saver.ConsoleLoggerSaver;

public interface Command {
    void accumulate(Command accumulator, ConsoleLoggerSaver saver);
    void flush();
    Command getPrevCommand();
    String messageDecorate();
}
