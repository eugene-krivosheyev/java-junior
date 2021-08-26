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

    public static void log(ObjectMessage message) {
        if (isFlushNeeded(message)) {
            flush();
        }
        if (AccumulativeMessage.isAncestor(message)) {
            message.process();
            lastLoggedMessage = message;
        } else {
            consoleSaver.save(message);
            lastLoggedMessage = null;
        }
    }

    private static boolean isLastLogTypeSame(ObjectMessage message) {
        return Objects.equals(message.getClass(),lastLoggedMessage.getClass());
    }

    private static boolean isFlushNeeded(ObjectMessage message){
        if (lastLoggedMessage == null) return false;
        boolean flushFlag = false;
        if (AccumulativeMessage.isAncestor(message)) {
            flushFlag = !isLastLogTypeSame(message);
        }
        flushFlag |= message.isNeedToFlush();
        return flushFlag;
    }
}
