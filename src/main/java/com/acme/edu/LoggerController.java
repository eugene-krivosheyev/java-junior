package com.acme.edu;

import com.acme.edu.command.*;
import com.acme.edu.saver.ConsoleLoggerSaver;
import com.sun.deploy.uitoolkit.ui.LoggerConsole;

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
            //command.accumulate(prevCommand);
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

    /*
        public void log(IntCommand command) {
            if(!localState.accumulate(command)){
                flush();
                localState.accumulate(command);
            }
        }
    */
    /*public void log(IntMasCommand command) {
        if (!localState.accumulate(command)) {
            flush();
            localState.accumulate(command);
        }
    }*/

   /* public void log(IntMas2Command command) {
        if (!localState.accumulate(command)) {
            flush();
            localState.accumulate(command);
        }
    }

    public void log(IntMas4Command command) {
        if (!localState.accumulate(command)) {
            flush();
            localState.accumulate(command);
        }
    }*/

    /*
        public void log(IntMas4Command command) {
            if(!localState.accumulate(command)){
                flush();
                localState.accumulate(command);
            }
        }
    */
/*
    public void log(StringCommand command) {
        if (!localState.accumulate(command)) {
            flush();
            localState.accumulate(command);
        }
    }*/

   /* public void log(CharCommand command) {
        if (!localState.accumulate(command)) {
            flush();
            localState.accumulate(command);
        }
    }

    public void log(BooleanCommand command) {
        if (!localState.accumulate(command)) {
            flush();
            localState.accumulate(command);
        }
    }

    public void log(ObjectCommand command) {
        if (!localState.accumulate(command)) {
            flush();
            localState.accumulate(command);
        }
    }*/

}
