package com.db.edu;

import com.db.edu.message.*;

public class Controller {
    private Message accumulateMessage;

    public void flush() {
        if (accumulateMessage != null) {
            accumulateMessage.flush();
        }
    }

    public void log(Message message) {
        if (!message.sameTypeOf(accumulateMessage)) {
            flush();
            accumulateMessage = message;
        } else {
            accumulateMessage = accumulateMessage.accumulate(message);
        }
    }
}
