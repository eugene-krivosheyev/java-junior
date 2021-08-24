package com.acme.edu.ooad.processor;

import com.acme.edu.ooad.message.ObjectMessage;

public class ObjectProcessor extends Processor {
    Object lastObject;

    @Override
    public ObjectMessage[] flush() {
        return new ObjectMessage[]{new ObjectMessage(lastObject)};
    }

    public ObjectMessage[] process(Object message) {
        this.lastObject = message;
        return flush();
    }
}
