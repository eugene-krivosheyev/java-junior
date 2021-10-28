package com.acme.edu;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;

public class LoggerController {
    private Printer printer;
    private Message oldMessage;

    public LoggerController(Printer printer) {
        this.printer = printer;
    }

    public void log(Message message){
        if(message == null)
            throw new IllegalArgumentException("Given message is null");

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
