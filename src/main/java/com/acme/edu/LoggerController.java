package com.acme.edu;

import com.acme.edu.exception.FlushException;
import com.acme.edu.exception.LogException;
import com.acme.edu.exception.SaverException;
import com.acme.edu.message.Message;
import com.acme.edu.saver.Saver;

import java.util.Arrays;

public class LoggerController {
    private final Iterable<Saver> savers;
    private Message state;

    public LoggerController(Saver... savers){
        this.savers = Arrays.asList(savers);
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
        catch (FlushException e) {
            throw new LogException(e.getMessage());
        }
    }

    public void flush() throws FlushException {
        for (Saver s : savers) {
            try {
                s.save(state);
                resetBuffer();
            } catch (SaverException e) {
                throw new FlushException("Save fail");
            }
        }
    }

    private void resetBuffer() {
        state = null;
    }
}
