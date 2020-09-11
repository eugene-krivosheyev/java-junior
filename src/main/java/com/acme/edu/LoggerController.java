package com.acme.edu;

import com.acme.edu.exception.LogException;
import com.acme.edu.exception.SaverException;
import com.acme.edu.message.Message;
import com.acme.edu.saver.Saver;

public class LoggerController {
    private Saver saver;
    private Message state;

    public LoggerController(Saver saver){
        this.saver = saver;
    }

    public void log(Message message) throws LogException {
        if (state == null) {
            state = message;
            return;
        }
        try {
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
        catch (SaverException e) {
            throw new LogException("Ooops!");
        }
    }

    public void flush() throws SaverException {
        saver.save(state);
        resetBuffer();
    }

    private void resetBuffer() {
        state = null;
    }
}
