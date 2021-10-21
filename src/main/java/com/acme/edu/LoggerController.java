package com.acme.edu;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;
import com.acme.edu.messages.ByteMessage;
import com.acme.edu.messages.IntMessage;
import com.acme.edu.State.Type;
import com.acme.edu.messages.StringMessage;

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
