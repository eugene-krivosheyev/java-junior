package com.acme.edu;

import com.acme.edu.message.Message;

public class LoggerController {
    private Message accumulator;

    public LoggerController() {
        accumulator = null;
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
            ConsoleSaver.writeToConsole(accumulator.getDecoratedMessage());
            accumulator = null;
        }
    }
}
