package com.acme.edu.LogWorkerDelegates;

import com.acme.edu.MessageDecorator.MessageDecorator;
import com.acme.edu.Saver.Saver;

public class LogWorkerDelegate {
    protected Saver saver;
    protected MessageDecorator messageDecorator;

    protected LogWorkerDelegate(Saver saver, MessageDecorator messageDecorator) {
        this.saver = saver;
        this.messageDecorator = messageDecorator;
    }
}
