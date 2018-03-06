package com.acme.edu.expressionproblem.handler;

import com.acme.edu.expressionproblem.message.IntMessage;
import com.acme.edu.expressionproblem.message.Message;
import com.acme.edu.expressionproblem.saver.LoggerSaver;

public class IntPrefixFormatMessageHandler extends LoggerHandler {
    public IntPrefixFormatMessageHandler(LoggerSaver saver, LoggerHandler nextHandler) {
        super(saver, nextHandler);
    }

    @Override
    protected void doHandle(Message message) {
        if (!(message instanceof IntMessage)) return;

        getSaver().save("primitive: " + message.toString());
    }
}
