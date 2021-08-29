package com.acme.edu.ooad.controller;

import com.acme.edu.ooad.message.*;
import com.acme.edu.ooad.saver.Saver;

public class LoggerController {
    final Saver saver;
    Message lastLoggedMessage;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void flush() {
        if (lastLoggedMessage == null) return;
        saver.save(lastLoggedMessage);
        lastLoggedMessage.clean();
    }

    public void log(Message message) {
        if (lastLoggedMessage == null) {
            lastLoggedMessage = message;
        } else {
            saver.save(lastLoggedMessage.getInstanceToPrint(message));
            lastLoggedMessage = lastLoggedMessage.getNewInstance(message);
        }
    }
}
