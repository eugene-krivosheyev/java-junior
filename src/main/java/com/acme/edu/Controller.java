package com.acme.edu;

public class Controller {
    Message currentMessage = null;
    private Saver saver;

    public Controller(Saver saver) {
        this.saver = saver;
    }

    public void log(Message message) {
        if (message.isSameType(currentMessage)) {
            currentMessage = message.accumulate(currentMessage);
        } else {
            if (currentMessage != null) {
                saver.save(currentMessage.decorate());
            }
            currentMessage = message;
        }
    }

    public void flush() {
        saver.save(currentMessage.decorate());
        currentMessage = null;
    }
}