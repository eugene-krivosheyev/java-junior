package com.acme.edu;

import com.acme.edu.message.Message;
import com.acme.edu.saver.Saver;

public class LoggerController {
    private Saver saver;
    private Message state;

    public LoggerController(Saver saver){
        this.saver = saver;
    }

    public void log(Message message){
        if (state == null) {
            state = message;
            return;
        }
        if (!state.isSameType(message)) {
            flush();
            state = message;
            return;
        }
        if (message.needFlush(state)) {
            flush();
            state = message;
        }
        else {
            state.updateAccumulator(message);
        }
    }

    public void flush() {
        saver.save(state);
        resetBuffer();
    }

    private void resetBuffer() {
        state = null;
    }
}
