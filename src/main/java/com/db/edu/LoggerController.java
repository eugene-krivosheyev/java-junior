package com.db.edu;

import com.db.edu.Message.IntMessage;
import com.db.edu.Message.Message;
import com.db.edu.Message.StringMessage;

public class LoggerController {

    State state = State.NULL;
    Message lastMessage;

    public void close() {
        if (state != State.NULL) {
            lastMessage.printAccumulated();
            state = State.NULL;
        }
    }

    public void log(Message message) {
        if (state == State.NULL) {
            lastMessage = message;
            state = State.NOT_NULL;
        } else if (message.typeEquals(lastMessage)) {
            lastMessage.accumulate(message);
        } else {
            lastMessage.printAccumulated();
            lastMessage = message;
        }
    }
}
