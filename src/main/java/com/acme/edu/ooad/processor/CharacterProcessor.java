package com.acme.edu.ooad.processor;

import com.acme.edu.ooad.message.CharMessage;
import com.acme.edu.ooad.message.ObjectMessage;

public class CharacterProcessor extends Processor {
    char lastChar;

    @Override
    public ObjectMessage[] flush() {
        return new ObjectMessage[]{new CharMessage(lastChar)};
    }

    public ObjectMessage[] process(char message) {
        this.lastChar = message;
        return flush();
    }
}
