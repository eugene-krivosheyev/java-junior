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
            Message previousMessage = oldMessage.accumulate(message);
            if (previousMessage != null) {
                printer.print(previousMessage);
            }
        } else {
            // TODO do it with using flush()
            printer.print(oldMessage);
            oldMessage = message;
        }
    }
    public void flush() {
        if (oldMessage != null) {
            printer.print(oldMessage);
        }
        oldMessage = null;
    }
}
