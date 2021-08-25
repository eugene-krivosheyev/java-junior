package com.db.edu;

import java.util.Objects;

public class Controller {
    private IntBuffer intBuffer = new IntBuffer();
    private StringBuffer stringBuffer = new StringBuffer();
    private int sum;
    State state = null;
    private int flagThereIsInteger;
    private int quantityString = 1;
    private String bufString;
    private ConsoleSaver consoleSaver;

    public void log(IntMessage message) {
        intBuffer.accumulate(message.getValue());
        if(state.equals(State.STRING)){
            consoleSaver.save(flushString());
        }
        state = State.INT;
    }

    public void log(StringMessage message) {
        stringBuffer.accumulate(message.getValue());
        if(state.equals(State.INT)){
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
            StringMessage m = new StringMessage(bufString);
            String result = m.decoratedString(quantityString);
            quantityString = 0;
            bufString = null;
            return result;
    }

    void flush() {
        if (!Objects.equals(bufString, null)) {
            consoleSaver.save(flushString());
        }
        if (flagThereIsInteger == 1) {
            consoleSaver.save(flushInt());
        }
    }
}
