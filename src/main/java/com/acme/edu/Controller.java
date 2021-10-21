package com.acme.edu;

import com.acme.edu.message.EmptyMessage;
import com.acme.edu.message.Message;
import com.acme.edu.printer.Printer;

public class Controller {

    private Printer printer = new Printer();

    private Message buffer = new EmptyMessage();

    public void logMessage(Message message){
        if (!message.isSum()) {
            endLogging(buffer.isEndLogging());
            sendLogToPrinter(message);
        } else {
            if (buffer.isEmpty()){
                buffer = message;
            } else {
                if (buffer.isSameType(message)) {
                    if(!buffer.isMAXMIN(message)) {
                        buffer.add(message);
                    } else {
                        sendLogToPrinter(buffer.add(message));
                        endLogging(buffer.isEndLogging());
                    }
                } else {
                    sendLogToPrinter(buffer);
                    buffer = message;
                }
            }
        }
    }

    public void endLogging(boolean isEnd) {
        if (!buffer.isEmpty() & isEnd ) {
            sendLogToPrinter(buffer);
            buffer = new EmptyMessage();
        }
    }

    private void sendLogToPrinter(Message message){
        printer.getMessage(message);
    }
}
