package com.acme.edu.command;

import com.acme.edu.saver.ConsoleLoggerSaver;
import com.acme.edu.saver.Saver;

public class NoneCommand implements Command {
    @Override
    public void accumulate(Command accumulator, Saver saver)  {

    }

    @Override
    public void flush() {
    }

    @Override
    public Command getPrevCommand() {
        return this;
    }

    @Override
    public String messageDecorate() {
        return null;
    }
}
