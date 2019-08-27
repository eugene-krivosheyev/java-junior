package com.acme.edu;

import commands.Command;

class LoggerController {

    private Saver saver;
    private Command notLogged = null;

    LoggerController(Saver saver) {
        this.saver = saver;
    }

    void log(Command command) {

        if (notLogged == null)
            notLogged = command;
        else if (notLogged.equalsCommand(command))
            notLogged = notLogged.getAccumulated(command);
        else {
            saver.save(notLogged.getDecorated());
            notLogged = command;
        }

    }

    void flush() {
        saver.save(notLogged.getDecorated());
        notLogged = null;
    }
}
