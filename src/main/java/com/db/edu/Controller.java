package com.db.edu;

import com.db.edu.message.IntMessage;
import com.db.edu.message.StringMessage;

public class Controller {
    private final StringMessage bufferS = new StringMessage(null);
    private final IntMessage bufferI = new IntMessage(0);
    State state = null;
    private final ConsoleSaver consoleSaver = new ConsoleSaver();

    public void log(IntMessage message) {
        bufferI.accumulate(message);
        if(!bufferS.isEmpty()){
            consoleSaver.save(bufferS.decoratedString());
            bufferS.flush();
        }
        state = State.INT;
    }

    public void log(StringMessage message) {
        if(!bufferS.isMessageEquals(message)) {
            consoleSaver.save(bufferS.decoratedString());
            bufferS.flush();
        }
        bufferS.accumulate(message);
        if(!bufferI.isEmpty()){
            consoleSaver.save(bufferI.decoratedInt());
            bufferI.flush();
        }
        state = State.STRING;
    }

    void flush() {
        if (!bufferS.isEmpty()) {
            consoleSaver.save(bufferS.decoratedString());
            bufferS.flush();
        }
        if (!bufferI.isEmpty()) {
            consoleSaver.save(bufferI.decoratedInt());
            bufferI.flush();
        }
    }
}
