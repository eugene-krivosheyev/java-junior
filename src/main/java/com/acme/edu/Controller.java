package com.acme.edu;

import com.acme.edu.message.EmptyMessage;
import com.acme.edu.message.DataEqualMessage;
import com.acme.edu.message.IllegalMessageExeption;
import com.acme.edu.printer.Printer;

public class Controller {
    private Printer printer;
    private DataEqualMessage buffer = new EmptyMessage();

    Controller(Printer newPrinter) {
        printer = newPrinter;
    }

    public void logMessage(DataEqualMessage message){
        if (!message.isSum()) {
            endLogging(buffer.isEndLogging());
            sendLogToPrinter(message);
        } else {
            if (buffer.isEmpty()){
                buffer = message;
            } else {
                try {
                    if(!buffer.isMAXMIN(message)) {
                        buffer.add(message);
                    } else {
                        sendLogToPrinter((DataEqualMessage) buffer.add(message));
                        endLogging(buffer.isEndLogging());
                    }
                } catch (IllegalMessageExeption e){
                    printer.print(e.getMessage());
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
