package com.acme.edu;

import com.acme.edu.message.Message;
import com.acme.edu.saver.Saver;

public class LoggerController {
    private Message accumulator;
    private Saver saver;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void log(Message message) {
        if (accumulator != null && accumulator.sameTypeOf(message)) {
            accumulator.accumulate(message);
        } else {
            flush();
            accumulator = message;
        }
    }

    public void flush() {
        if (accumulator != null) {
            saver.save(accumulator.getDecoratedMessage());
            accumulator = null;
        }
    }
}
