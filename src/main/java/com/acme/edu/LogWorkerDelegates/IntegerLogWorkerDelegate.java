package com.acme.edu.LogWorkerDelegates;

import com.acme.edu.MessageDecorator.MessageDecorator;
import com.acme.edu.Saver.Saver;

public class IntegerLogWorkerDelegate extends IntLogWorkerDelegate {
    public IntegerLogWorkerDelegate(Saver saver, MessageDecorator messageDecorator) {
        super(saver, messageDecorator);
    }

    public void log(int message) {
        if (message == 0) {
            saver.save(messageDecorator.getDecoratedMessage(message));
        } else {
            if (longBuffer + message > Integer.MAX_VALUE) {
                flushOverflowedBuffer(Integer.MAX_VALUE, message);
            } else {
                longBuffer += message;
            }
        }
    }
}
