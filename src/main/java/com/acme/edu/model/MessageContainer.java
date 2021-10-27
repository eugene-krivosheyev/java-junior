package com.acme.edu.model;

import com.acme.edu.model.exception.LoggerException;
import com.acme.edu.model.message.Message;
import com.acme.edu.model.message.NullMessage;
import com.acme.edu.model.printer.ConsolePrinter;
import com.acme.edu.model.printer.Printer;


public class MessageContainer {
    private Message lastMessage = new NullMessage();

    public void addMessage(Message message) {
        try {
            if (lastMessage.canAccumulateMessage(message)) {
                lastMessage = lastMessage.getAccumulatedMessage(message);
            } else {
                flush();
                lastMessage = message;
            }
        } catch (LoggerException e) {
            System.out.println("Exception in addMessage");
        }
    }

    public void flush() {
        Printer printer = new ConsolePrinter(lastMessage.toString());
        try {
            printer.print();
        } catch (LoggerException e) {
            System.out.println("Unable to log last message");
        }
        lastMessage = new NullMessage();
    }
}
