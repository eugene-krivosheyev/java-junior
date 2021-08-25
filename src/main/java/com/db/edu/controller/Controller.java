package com.db.edu.controller;

import java.io.PrintStream;
import com.db.edu.command.*;
import com.db.edu.saver.Saver;

public class Controller {

    private Command currentCommand;
    private Saver saver = new Saver();

    public void log(Command command){
        if (currentCommand==null) {
            currentCommand=command;
            return;
        }
        if (currentCommand.canAccumulate(command)){
            currentCommand = currentCommand.accumulate(command);
        }
        else
        {
            saver.save(currentCommand.getDecoratedMessage());
            currentCommand=command;
        }
    }

    public void flush() {
        saver.save(currentCommand.getDecoratedMessage());
        currentCommand = null;
    }
}
