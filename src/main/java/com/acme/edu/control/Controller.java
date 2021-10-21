package com.acme.edu.control;

import com.acme.edu.control.message.EmptyMessage;
import com.acme.edu.control.message.Message;
import com.acme.edu.control.printer.Printer;

import java.util.ArrayList;

public class Controller {

    Printer printer = new Printer();

    private Message buffer = new EmptyMessage();

    public void sendMessage(Message message){
        if (!message.isSum()) {
            endLogging(buffer.isEndLogging());
            log(message);
        } else {
            if (buffer.isEmpty()){
                buffer = message;
            } else {
                if (buffer.isSameType(message)) {
                    if(!buffer.isMAXMIN(message)) {
                        buffer.add(message);
                    } else {
                        log(buffer.add(message));
                        endLogging(buffer.isEndLogging());
                    }
                } else {
                    log(buffer);
                    buffer = message;
                }
            }
        }
    }

    public void log(Message message){
        printer.save(message);
    }


    public void endLogging(boolean isEnd) {
        if (!buffer.isEmpty() & isEnd ) {
            log(buffer);
            buffer = new EmptyMessage();
        }
    }

}
