package com.acme.edu.loggers;

import com.acme.edu.common.CommonLogger;
import com.acme.edu.common.Message;
import com.acme.edu.messages.IntMessage;

public class IntLogger implements CommonLogger {
    private Message message;
    @Override
    public void log(Message message) {
        message.getDecoratedString();
    }
}
