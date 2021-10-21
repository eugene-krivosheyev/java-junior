package com.acme.edu;

import com.acme.edu.message.EmptyMessage;
import com.acme.edu.message.DataEqualMessage;
import com.acme.edu.printer.Printer;

public class Controller {

    private Printer printer = new Printer();

    private DataEqualMessage buffer = new EmptyMessage();

    public void logMessage(DataEqualMessage message){
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
                        sendLogToPrinter((DataEqualMessage) buffer.add(message));
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

    private void sendLogToPrinter(DataEqualMessage message){
        printer.getMessage(message);
    }
}
