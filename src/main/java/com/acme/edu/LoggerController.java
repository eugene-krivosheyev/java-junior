package com.acme.edu;

import com.acme.edu.command.*;
import com.acme.edu.saver.ConsoleLoggerSaver;

public class LoggerController {
    private Command prevCommand;
    private ConsoleLoggerSaver loggerSaver;

    public void log(Command command) {
        if (prevCommand.getType().equals(Type.NONE)) {
            prevCommand = command;
        } else if (command.accumulate(prevCommand)) {
            prevCommand = command;
        } else {
            flush();
            log(command);
        }
    }

    public void flush() {
        loggerSaver.save(prevCommand);
        prevCommand = new NoneCommand();
    }

    public LoggerController(ConsoleLoggerSaver consoleLoggerSaver){
        this.loggerSaver = consoleLoggerSaver;
        this.prevCommand = new NoneCommand();
    }
}
