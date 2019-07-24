package com.acme.edu;

import com.acme.edu.command.*;
import com.acme.edu.exceptions.EmptySaverException;
import com.acme.edu.saver.ConsoleLoggerSaver;

import java.io.IOException;

public class LoggerController {
    private Command prevCommand;
    private ConsoleLoggerSaver loggerSaver;

    public void log(Command command) throws EmptySaverException, IOException {
        if(loggerSaver==null)
            throw new EmptySaverException("Saver is null");
        command.accumulate(prevCommand,loggerSaver);
        prevCommand = command.getPrevCommand();
    }

    public void flush() throws IOException {
        prevCommand.flush();
        prevCommand=new NoneCommand();
    }

    public LoggerController(ConsoleLoggerSaver consoleLoggerSaver) {
        this.loggerSaver = consoleLoggerSaver;
        this.prevCommand = new NoneCommand();
    }
}
