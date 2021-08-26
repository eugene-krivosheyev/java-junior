package com.db.edu;

import com.db.edu.message.*;

public class Controller {
    private Message accumulateMessage;

    public void flush() {
        if (accumulateMessage != null) {
            accumulateMessage.flush();
        }
    }

    public void log(Message message) {
        if (!message.sameTypeOf(accumulateMessage)) {
            flush();
            accumulateMessage = message;
        } else {
            accumulateMessage = accumulateMessage.accumulate(message);
        }
    }

//    public void log(BooleanMessage message) {
//        saver.save(PRIMITIVE_PREFIX.getMessage() + message);
//    }
//
//    public void log(char message) {
//        saver.save(CHAR_PREFIX.getMessage() + message);
//    }
//
//    public void log(Object message) {
//        saver.save(OBJECT_PREFIX.getMessage() + message);
//    }
//
//    public void log(int ... message) {
//        for (int value : message) {
//            log(new IntMessage(value));
//        }
//        flush();
//    }
//
//    public void log(String ... message) {
//        for (String value : message) {
//            log(new StringMessage(value));
//        }
//        flush();
//    }

}
