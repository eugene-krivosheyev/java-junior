package com.db.edu;

import com.db.edu.saver.SaveException;
import com.db.edu.saver.Saver;
import com.db.edu.messagepack.message.EmptyMessage;
import com.db.edu.messagepack.message.Message;

public class Controller {
    private Message previousMessage = new EmptyMessage();
    private Saver saver;

    public Controller(Saver saver) {
        this.saver = saver;
    }

    public void log(Message message) {
        if(message == null) {
            throw new IllegalArgumentException("Controller: message is empty");
        }
        if (previousMessage.isSameType(message)) {
            previousMessage = previousMessage.accumulate(message);
        } else {
            flush();
            previousMessage = message;
        }
    }

    public void flush() {
        try {
            saver.save(previousMessage);
            previousMessage.resetFields();
        } catch (SaveException e) {
            e.printStackTrace();
            System.out.println("Controller: empty message is received");
        }
    }
}
