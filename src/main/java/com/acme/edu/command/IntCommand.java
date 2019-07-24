package com.acme.edu.command;

import com.acme.edu.saver.ConsoleLoggerSaver;

import java.io.IOException;

public class IntCommand implements Command {
    private int message = 0;
    private ConsoleLoggerSaver saver = null;
    private Command prevCommand = null;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public void accumulate(Command command, ConsoleLoggerSaver saver) throws IOException {
        this.saver = saver;
        if (command instanceof NoneCommand) {
            prevCommand = this;
        } else if (isAccumulative(command)) {
            message = message + ((IntCommand) command).message;
            prevCommand = this;
        } else {
            prevCommand = command;
            flush();
        }

    }

    private boolean isAccumulative(Command command)  {
        if (command instanceof IntCommand) {
            int intBuff = ((IntCommand) command).message;
            if (intBuff > 0 && (Integer.MAX_VALUE - intBuff < message)) return false;
            if (intBuff <= 0 && (Integer.MIN_VALUE - intBuff > message)) return false;
            return true;
        }
        return false;
    }

    public String messageDecorate() {
        return String.valueOf(message);
    }

    @Override
    public void flush() throws IOException {
        saver.save(prevCommand.messageDecorate());
        prevCommand = this;
    }

    @Override
    public Command getPrevCommand() {
        return prevCommand;
    }
}
