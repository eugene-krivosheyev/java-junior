package com.acme.edu;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;

public class LoggerController {
    Printer printer = new ConsolePrinter();

    Message oldMessage;

    public void log(Message message) {
        if (oldMessage == null) {
            oldMessage = message;
            return;
        }
        if (oldMessage.isSameType(message)) {
            oldMessage.accumulate(message, printer);
        } else {
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
