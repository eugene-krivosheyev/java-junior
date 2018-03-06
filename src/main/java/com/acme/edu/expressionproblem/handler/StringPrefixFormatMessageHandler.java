package com.acme.edu.expressionproblem.handler;

import com.acme.edu.expressionproblem.message.Message;
import com.acme.edu.expressionproblem.message.StringMessage;
import com.acme.edu.expressionproblem.saver.LoggerSaver;

public class StringPrefixFormatMessageHandler extends LoggerHandler {
    public StringPrefixFormatMessageHandler(LoggerSaver saver, LoggerHandler nextHandler) {
        super(saver, nextHandler);
    }

    @Override
    protected void doHandle(Message message) {
        if (!(message instanceof StringMessage)) return;

        getSaver().save("string: " + message.toString());
    }
}
