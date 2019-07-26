package com.acme.edu;

import com.acme.edu.command.*;
import com.acme.edu.exceptions.EmptySaverException;
import com.acme.edu.saver.ConsoleLoggerSaver;
import com.acme.edu.saver.Saver;

import java.io.IOException;

public class LoggerController {
    private Command prevCommand;
    private Saver loggerSaver;

    public LoggerController(Saver saver) {
        this.loggerSaver = saver;
        this.prevCommand = new NoneCommand();
    }

    public void log(Command command) throws EmptySaverException, IOException {
        if (loggerSaver == null) throw new EmptySaverException("Saver is not provided");
        command.accumulate(prevCommand, loggerSaver);
        prevCommand = command.getPrevCommand();
    }

    public void flush() throws IOException {
        prevCommand.flush();
        prevCommand = new NoneCommand();
    }

    public void close() throws IOException {
        this.flush();
        loggerSaver.close();
    }

    public void setLoggerSaver(Saver saver){
        loggerSaver = saver;
    }
}
