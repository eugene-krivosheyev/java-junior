package com.acme.edu;

import com.acme.edu.commands.Command;

class LoggerController {
    private SuperSaver saver;
    private Command currentState;

    LoggerController(SuperSaver saver) {
        this.saver = saver;
    }

    void log(Command command) {
        if (command.isTypeEquals(currentState)) {
            currentState = currentState.accumulate(command);
        } else {
            if (currentState != null) {
                saver.save(currentState.getDecorated());
            }
            currentState = command;
        }
    }

    void flush() {
        if (currentState == null) {
            return;
        }

        saver.save(currentState.getDecorated());
        currentState = null;
    }
}
