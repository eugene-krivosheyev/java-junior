package com.acme.edu;

import com.acme.edu.message.EmptyMessage;
import com.acme.edu.message.Message;
import com.acme.edu.saver.Saver;

public class LoggerController {
    private Message accumulator = new EmptyMessage();
    private final Message EMPTY_MESSAGE = new EmptyMessage();
    private Saver consoleSaver;

    public LoggerController(Saver consoleSaver) {
        this.consoleSaver = consoleSaver;
    }

    public void log(Message message) {
        if (accumulator.sameTypeOf(message)) {
            accumulator.accumulate(message);
        } else {
            flush();
            accumulator = message;
        }
    }

    public void flush() {
            consoleSaver.save(accumulator.getDecoratedMessage());
            accumulator = EMPTY_MESSAGE;
    }
}
