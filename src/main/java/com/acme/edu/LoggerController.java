package com.acme.edu;

import com.acme.edu.commands.Command;
import com.acme.edu.savers.Saver;

class LoggerController {
    private Saver saver;
    private Command currentState;

    LoggerController(Saver saver) {
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
