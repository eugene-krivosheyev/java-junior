package com.acme.edu.ooad.controller;

import com.acme.edu.ooad.message.*;
import com.acme.edu.ooad.saver.ConsoleSaver;

import java.util.Objects;

public class LoggerController {
    private static final ConsoleSaver consoleSaver = new ConsoleSaver();

    private static ObjectMessage lastLoggedMessage = null;

    public static void flush() {
        consoleSaver.save(lastLoggedMessage);
        lastLoggedMessage.clean();
    }

    public static void log(StringMessage message) {
        boolean isLastLoggedAnotherType = isFlushNeeded(message);
        if ( isLastLoggedAnotherType || message.isNeedToFlush() ) {
            flush();
        }

        message.process();
        lastLoggedMessage = message;
    }

    public static void log(IntegerMessage message) {
        if (isFlushNeeded(message)) {
            flush();
        }

        message.process();
        lastLoggedMessage = message;
    }

    public static void log(ByteMessage message) {
        if (isFlushNeeded(message)) {
            flush();
        }

        message.process();
        lastLoggedMessage = message;
    }

    public static void log(ObjectMessage message) {
        if (isFlushNeeded(message)) {
            flush();
        }

        consoleSaver.save(message);
        lastLoggedMessage = null;
    }

    private static boolean isLastLogTypeSame(ObjectMessage message) {
        return Objects.equals(message.getClass(),lastLoggedMessage.getClass());
    }

    private static boolean isFlushNeeded(ObjectMessage message){
        if (lastLoggedMessage == null) return true;
        if (AccumulatedMessage.class.isAssignableFrom(message.getClass())) {
            return !isLastLogTypeSame(message);
        }
        return false;
    }
}
