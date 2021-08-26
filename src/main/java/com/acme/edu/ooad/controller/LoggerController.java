package com.acme.edu.ooad.controller;

import com.acme.edu.ooad.message.*;
import com.acme.edu.ooad.saver.ConsoleSaver;

import java.util.Objects;

public class LoggerController {
    private static final ConsoleSaver consoleSaver = new ConsoleSaver();

    private static Message lastLoggedMessage = null;

    public static void flush() {
        consoleSaver.save(lastLoggedMessage);
        lastLoggedMessage.clean();
    }

    public static void log(Message message) {
        if (isFlushNeeded(message)) {
            flush();
        }
        if (lastLoggedMessage == null) {
            lastLoggedMessage = message;
        } else {
            lastLoggedMessage = lastLoggedMessage.process(message);
        }
        if (!AccumulativeMessage.isAccumulative(message)) {
            consoleSaver.save(message);
        }
    }

    private static boolean isLastLogTypeSame(Message message) {
        return Objects.equals(message.getClass(),lastLoggedMessage.getClass());
    }

    private static boolean isFlushNeeded(Message message){
        if (lastLoggedMessage == null) return false;
        boolean flushFlag = false;
        if (AccumulativeMessage.isAccumulative(message)) {
            flushFlag = !isLastLogTypeSame(message);
        }
        flushFlag |= lastLoggedMessage.isNeedToFlush(message);
        return flushFlag;
    }
}
