package com.acme.edu;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;

public class Controller {
    private Saver saver = new Saver();
    private Message prevMessage;

    public void log(Message message) {
        if (prevMessage == null) {
            prevMessage = message;
        } else if (prevMessage.isAbleToAccumulate(message)) {
            prevMessage = prevMessage.accumulate(message);
        } else {
            saver.save(prevMessage.decorate());
            prevMessage = message;
        }
    }
}
