package com.acme.edu;

import com.acme.edu.Saver.SuperSaver;
import com.acme.edu.commands.Command;

public class LoggerController {
    private SuperSaver saver;
    private Command currentState = null;

    public LoggerController(SuperSaver saver) {
        this.saver = saver;
    }

    public void log(Command command) {
        if (command.isTypeEqual(currentState) && !command.isSaveRequired(currentState)) {
            currentState = command.accumulate(currentState);
        } else {
            if (currentState != null) {
                saver.save(currentState.getDecorated());
            }
            currentState = command;
        }
    }

    public void flush() {
        saver.save(currentState.getDecorated());
    }
}
