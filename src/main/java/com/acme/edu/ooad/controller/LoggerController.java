package com.acme.edu.ooad.controller;

import com.acme.edu.ooad.message.*;
import com.acme.edu.ooad.saver.Saver;

import java.util.Objects;

public class LoggerController {
    private final Saver saver;
    private Message lastLoggedMessage;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void flush() {
        if (lastLoggedMessage == null) return;
        saver.save(lastLoggedMessage);
        lastLoggedMessage.clean();
    }

    public void log(Message message) {
        if (lastLoggedMessage != null) {
            saver.save(lastLoggedMessage.getInstanceToPrint(message));
        }
        lastLoggedMessage = lastLoggedMessage == null ? message : lastLoggedMessage.getNewInstance(message);
    }
}
