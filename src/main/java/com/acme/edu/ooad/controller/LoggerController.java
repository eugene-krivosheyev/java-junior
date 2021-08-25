package com.acme.edu.ooad.controller;

import com.acme.edu.ooad.message.*;
import com.acme.edu.ooad.saver.ValidatingSaver;

public class LoggerController {

    private ObjectMessage lastLogMessage;
    private ValidatingSaver saver;

    public LoggerController(ValidatingSaver saver) {
        this.saver = saver;
    }

    public void log(BooleanMessage boolMessage) {
        flush();
        saver.save(boolMessage);
    }

    public void log(CharMessage charMessage) {
        flush();
        saver.save(charMessage);
    }

    public void log(ByteMessage byteMessage) {
        if (lastLogMessage != null && !(lastLogMessage instanceof ByteMessage)) {
            saver.save(lastLogMessage);
        }

        byteMessage.process();
        updateLastLoggedMessage(byteMessage);
    }

    public void log(IntegerMessage intMessage) {
        if (lastLogMessage != null && !(lastLogMessage instanceof IntegerMessage)) {
            saver.save(lastLogMessage);
        }

        intMessage.process();
        updateLastLoggedMessage(intMessage);
    }

    public void log(StringMessage strMessage) {
        if (lastLogMessage != null &&
            (!(lastLogMessage instanceof StringMessage) || strMessage.isNewString())) {
            saver.save(lastLogMessage);
        }

        strMessage.process();
        updateLastLoggedMessage(strMessage);
    }

    public void log(ObjectMessage objMessage) {
        flush();
        saver.save(objMessage);
    }

    public void flush() {
        if (lastLogMessage != null) {
            saver.save(lastLogMessage);
            updateLastLoggedMessage(null);
        }
    }

    private void updateLastLoggedMessage(ObjectMessage newMessage) {
        if (lastLogMessage != null) {
            lastLogMessage.clean();
        }
        lastLogMessage = newMessage;
    }
}
