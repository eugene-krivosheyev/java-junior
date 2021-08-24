package com.acme.edu.ooad.processor;

import com.acme.edu.ooad.message.BooleanMessage;
import com.acme.edu.ooad.message.ObjectMessage;

public class BooleanProcessor extends Processor {
    boolean lastBoolean;

    @Override
    public ObjectMessage[] flush() {
        return new ObjectMessage[]{new BooleanMessage(lastBoolean)};
    }

    public ObjectMessage[] process(boolean message) {
        this.lastBoolean = message;
        return flush();
    }
}
