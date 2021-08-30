package com.acme.edu;

import com.acme.edu.message.EmptyMessage;
import com.acme.edu.message.Message;
import com.acme.edu.saver.SaveException;
import com.acme.edu.saver.Saver;

public class LoggerController {
    private Message accumulator = new EmptyMessage();
    private final Message EMPTY_MESSAGE = new EmptyMessage();
    private final Saver saver;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void log(Message message) throws SaveException {
        if (accumulator.sameTypeOf(message)) {
            accumulator = accumulator.accumulate(message);
        } else {
            flush();
            accumulator = message;
        }
    }

    public void flush() throws SaveException {
        String decoratedMessage = accumulator.getDecoratedMessage();
        
        if(decoratedMessage != null){
            saver.save(decoratedMessage);
        }
        
        accumulator = EMPTY_MESSAGE;
    }
}
