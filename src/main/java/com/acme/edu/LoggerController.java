package com.acme.edu;

import com.acme.edu.message.*;

import java.util.*;

public class LoggerController {
    private Message accumulator;

    private final ClassValidator classValidator;

    public LoggerController() {
        classValidator = new ClassValidator();
        accumulator = null;
    }

    public void log(Message message) {
        if (accumulator != null && accumulator.sameTypeOf(message)) {
            accumulator.accumulate(message);
        } else {
            flush();
            accumulator = message;
        }
    }

    public void flush() {
        if (accumulator != null) {
            ConsoleSaver.writeToConsole(accumulator.getDecoratedMessage());
            accumulator = null;
        }
    }

//    public void log(IntMessage message) {
//        if (classValidator.setCurrentClass(message)) {
//            if (accumulator != null) {
//                accumulator.accumulate(message);
//            } else {
//                accumulator = message;
//            }
//
//        } else {
//            flush();
//            accumulator = message;
//        }
//    }
//
//    public void log(ByteMessage message) {
//        if (classValidator.setCurrentClass(message)) {
//            if (accumulator != null) {
//                accumulator.accumulate(message);
//            } else {
//                accumulator = message;
//            }
//        } else {
//            flush();
//            accumulator = message;
//        }
//    }
//
//    public void log(StringMessage message) {
//        if (classValidator.setCurrentClass(message) && accumulator != null && Objects.equals(accumulator.getBody(), message.getBody())) {
//            accumulator.accumulate(message);
//        } else {
//            flush();
//            accumulator = message;
//        }
//    }
//
//    public void log(ReferenceMessage message) {
//        flush();
//    }


}
