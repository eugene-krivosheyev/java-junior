package com.acme.edu;

public class Controller {
    private Message currentMessage = null;
    private Saver saver;

    public Controller(Saver saver) {
        this.saver = saver;
    }

    public Controller(Saver saver, Message currentMessage) {
        this.saver = saver;
        this.currentMessage = currentMessage;
    }

    public Message getCurrentMessage() {
        return currentMessage;
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
        if (currentMessage != null) {
            saver.save(currentMessage.decorate());
            currentMessage = null;
        }
    }
}