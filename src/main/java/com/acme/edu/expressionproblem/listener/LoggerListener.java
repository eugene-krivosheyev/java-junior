package com.acme.edu.expressionproblem.listener;

import com.acme.edu.expressionproblem.message.Message;
import com.acme.edu.expressionproblem.saver.LoggerSaver;

public abstract class LoggerListener {
    private LoggerSaver loggerSaver;

    protected LoggerListener(LoggerSaver loggerSaver) {
        this.loggerSaver = loggerSaver;
    }

    public LoggerSaver getLoggerSaver() {
        return loggerSaver;
    }

    public abstract void fireEvent(Message message);
}
