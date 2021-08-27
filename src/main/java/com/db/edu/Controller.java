package com.db.edu;

public class Controller {
    private ConsoleSaver consoleSaver = new ConsoleSaver();
    private Message previousMessage;

    public void log(Message message) {
        if (previousMessage.isSameType(message)) {
            this.previousMessage = previousMessage.accumulate(message);
        } else {
            flush(message);
        }
        previousMessage = message;
    }

    public void flush(Message message) {
        consoleSaver.save(message);
    }
}
