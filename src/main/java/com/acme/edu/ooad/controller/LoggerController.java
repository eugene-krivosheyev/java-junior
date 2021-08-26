package com.acme.edu.ooad.controller;

import com.acme.edu.ooad.message.*;
import com.acme.edu.ooad.saver.ConsoleSaver;
import com.acme.edu.ooad.saver.Saver;

public class LoggerController {
    private final Saver saver;
    private ObjectMessage lastLoggedMessage = null;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void flush() {
        saver.save(lastLoggedMessage);
        lastLoggedMessage.clean();
    }

    public void log(StringMessage message) {
        boolean isLastLoggedAnotherType = lastLoggedMessage != null && !(lastLoggedMessage instanceof StringMessage);
        if ( isLastLoggedAnotherType || message.isNeedToFlush() ) {
            flush();
        }

        message.process();
        lastLoggedMessage = message;
    }

    public void log(IntegerMessage message) {
        if ( lastLoggedMessage != null && !(lastLoggedMessage instanceof IntegerMessage) ) {
            flush();
        }

        message.process();
        lastLoggedMessage = message;
    }

    public void log(ByteMessage message) {
        if ( lastLoggedMessage != null && !(lastLoggedMessage instanceof ByteMessage) ) {
            flush();
        }

        message.process();
        lastLoggedMessage = message;
    }

    public void log(ObjectMessage message) {
        if ( lastLoggedMessage != null ) {
            flush();
        }

        saver.save(message);
        lastLoggedMessage = null;
    }
}
