package com.acme.edu;

import com.acme.edu.command.*;
import com.acme.edu.saver.ConsoleLoggerSaver;

public class LoggerController {
    private Command prevCommand;
    private ConsoleLoggerSaver loggerSaver;

    public void log(Command command) {
        command.accumulate(prevCommand,loggerSaver);
        prevCommand = command.getPrevCommand();
    }

    public void flush() {
        prevCommand.flush();
        prevCommand=new NoneCommand();
    }

    public LoggerController(ConsoleLoggerSaver consoleLoggerSaver) {
        this.loggerSaver = consoleLoggerSaver;
        this.prevCommand = new NoneCommand();
    }
}
