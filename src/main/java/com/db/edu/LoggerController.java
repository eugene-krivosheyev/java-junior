package com.db.edu;

import com.db.edu.Message.Message;
import com.db.edu.Save.SaveException;
import com.db.edu.Save.Saver;

public class LoggerController {

    State state = State.NULL;
    Message lastMessage;
    private final Saver saver;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void close() throws SaveException {
        if (state != State.NULL) {
            lastMessage.close();
            saver.save(lastMessage.decorate());
            state = State.NULL;
            lastMessage = null;
        }
    }

    public void log(Message message) throws SaveException {
        if (state == State.NULL) {
            lastMessage = message;
            state = State.NOT_NULL;
        } else if (message.typeEquals(lastMessage)) {
            lastMessage.accumulate(message);
        } else {
            lastMessage.close();
            saver.save(lastMessage.decorate());
            lastMessage = message;
        }
    }

    public Message getLastMessage(){
        return lastMessage;
    }
}
