package com.db.edu;

import java.util.Objects;

public class Controller {
    private IntBuffer intBuffer = new IntBuffer();
    private StringBuffer stringBuffer = new StringBuffer();
    State state = null;
    private ConsoleSaver consoleSaver = new ConsoleSaver();

    public void log(IntMessage message) {
        intBuffer.accumulate(message.getValue());
        if(!stringBuffer.isEmpty()){
            consoleSaver.save(flushString());
        }
        state = State.INT;
    }

    public void log(StringMessage message) {
        if(!stringBuffer.isStringEquals(message.getValue())) {
            consoleSaver.save(flushString());
        }
        stringBuffer.accumulate(message.getValue());
        if(!intBuffer.isEmpty()){
            consoleSaver.save(flushInt());
        }
        state = State.STRING;
    }

    private String flushInt() {
            IntMessage m = new IntMessage(intBuffer.getSum());
            intBuffer.bufferFlush();
            return m.decoratedInt();
    }

    private String flushString() {
            StringMessage m = new StringMessage(stringBuffer.getBufString());
            String result = m.decoratedString(stringBuffer.getQuantityString());
            stringBuffer.bufferFlush();
            return result;
    }

    void flush() {
        if (!stringBuffer.isEmpty()) {
            consoleSaver.save(flushString());
        }
        if (!intBuffer.isEmpty()) {
            consoleSaver.save(flushInt());
        }
    }
}
