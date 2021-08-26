package com.acme.edu.ooad.controller;

import com.acme.edu.ooad.message.*;
import com.acme.edu.ooad.saver.ConsoleSaver;

public class LoggerController {
    private static final ConsoleSaver consoleSaver = new ConsoleSaver();

    private static ObjectMessage lastLoggedMessage = null;

    public static void flush() {
        consoleSaver.save(lastLoggedMessage);
        lastLoggedMessage.clean();
    }

    public static void log(StringMessage message) {
        boolean isLastLoggedAnotherType = lastLoggedMessage != null && !(lastLoggedMessage instanceof StringMessage);
        if ( isLastLoggedAnotherType || message.isNeedToFlush() ) {
            flush();
        }

        message.process();
        lastLoggedMessage = message;
    }

    public static void log(IntegerMessage message) {
        if ( lastLoggedMessage != null && !(lastLoggedMessage instanceof IntegerMessage) ) {
            flush();
        }

        message.process();
        lastLoggedMessage = message;
    }

    public static void log(ByteMessage message) {
        if ( lastLoggedMessage != null && !(lastLoggedMessage instanceof ByteMessage) ) {
            flush();
        }

        message.process();
        lastLoggedMessage = message;
    }

    public static void log(ObjectMessage message) {
        if ( lastLoggedMessage != null ) {
            flush();
        }

        consoleSaver.save(message);
        lastLoggedMessage = null;
    }
}
