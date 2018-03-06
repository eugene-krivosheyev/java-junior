package com.acme.edu.expressionproblem.listener;

import com.acme.edu.expressionproblem.message.Message;
import com.acme.edu.expressionproblem.message.StringMessage;
import com.acme.edu.expressionproblem.saver.LoggerSaver;

public class StringPrefixFormatMessageListener extends LoggerListener {
    public StringPrefixFormatMessageListener(LoggerSaver loggerSaver) {
        super(loggerSaver);
    }

    @Override
    public void fireEvent(Message message) {
        if (!(message instanceof StringMessage)) return;

        getLoggerSaver().save("string: " + message); //message.toString() implicitly
    }
}
