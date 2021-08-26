package com.acme.edu.ooad.controller;

import com.acme.edu.ooad.message.*;
import com.acme.edu.ooad.saver.Saver;

import java.util.Objects;

public class LoggerController {
    private final Saver saver;
    private Message lastLoggedMessage;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void flush() {
        saver.save(lastLoggedMessage);
        lastLoggedMessage.clean();
    }

    public void log(Message message) {
        if (isFlushNeeded(message)) {
            flush();
        }
        if (lastLoggedMessage == null) {
            lastLoggedMessage = message;
        } else {
            lastLoggedMessage = lastLoggedMessage.process(message);
        }
        if (!AccumulativeMessage.isAccumulative(message)) {
            saver.save(message);
        }
    }

    private boolean isLastLogTypeSame(Message message) {
        return Objects.equals(message.getClass(),lastLoggedMessage.getClass());
    }

    private boolean isFlushNeeded(Message message){
        if (lastLoggedMessage == null) return false;
        boolean flushFlag = false;
        if (AccumulativeMessage.isAccumulative(message)) {
            flushFlag = !isLastLogTypeSame(message);
        }
        flushFlag |= lastLoggedMessage.isNeedToFlush(message);
        return flushFlag;
    }
}
