package com.acme.edu.expressionproblem.handler;

import com.acme.edu.expressionproblem.message.Message;
import com.acme.edu.expressionproblem.saver.LoggerSaver;

public abstract class LoggerHandler {
    private LoggerHandler nextHandler;
    private LoggerSaver saver;

    protected LoggerHandler(LoggerSaver saver, LoggerHandler nextHandler) {
        this.saver = saver;
        this.nextHandler = nextHandler;
    }

    public LoggerHandler getNextHandler() {
        return nextHandler;
    }

    public void handleMessage(Message message) {
        doHandle(message);

        if (nextHandler != null) {
            nextHandler.handleMessage(message);
        }
    }

    protected LoggerSaver getSaver() {
        return saver;
    }

    protected abstract void doHandle(Message message);
}
