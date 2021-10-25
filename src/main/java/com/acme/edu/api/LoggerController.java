package com.acme.edu.api;

import com.acme.edu.api.message.*;
import com.acme.edu.api.saver.Saver;

public class LoggerController {
    private Message currentMessage = null;

    private final Saver saver;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void log(Message message) {
        if (!message.typeEquals(currentMessage)) {
            flush();
            currentMessage = message;
        } else {
            currentMessage = currentMessage.accumulate(message);
        }
    }

    public void flush() {
        if (currentMessage == null) {
            return;
        }
        print(currentMessage.getMessageAsString());
        currentMessage = null;
    }

    private void print(String message) {
        saver.print(message);
    }
}
