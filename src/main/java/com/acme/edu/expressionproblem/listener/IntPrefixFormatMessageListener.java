package com.acme.edu.expressionproblem.listener;

import com.acme.edu.expressionproblem.message.IntMessage;
import com.acme.edu.expressionproblem.message.Message;
import com.acme.edu.expressionproblem.saver.LoggerSaver;

public class IntPrefixFormatMessageListener extends LoggerListener {
    public IntPrefixFormatMessageListener(LoggerSaver loggerSaver) {
        super(loggerSaver);
    }

    @Override
    public void fireEvent(Message message) {
        if (!(message instanceof IntMessage)) return;

        getLoggerSaver().save("primitive: " + message); //message.toString() implicitly
    }
}
