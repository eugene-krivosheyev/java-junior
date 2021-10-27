package com.acme.edu;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;

public class LoggerController {
    Printer printer;

    public LoggerController(Printer printer) {
        this.printer = printer;
    }

    Message oldMessage;

    public void log(Message message) {
        if (oldMessage == null) {
            oldMessage = message;
            return;
        }
        if (oldMessage.isSameType(message)) {
            Message newMessage = oldMessage.accumulate(message);
            if (newMessage != null) {
                flush(newMessage);
            }
        } else {
            flush(message);
        }
    }
    public void flush() {
        flush(null);
    }

    private void flush(Message newMessage) {
        if (oldMessage != null) {
            printer.print(oldMessage);
        }
        oldMessage = newMessage;
    }
}
