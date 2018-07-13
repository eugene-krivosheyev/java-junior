package com.acme.edu.LogWorkerDelegates;

import com.acme.edu.MessageDecorator.MessageDecorator;
import com.acme.edu.Saver.Saver;

public class IntLogWorkerDelegate extends LogWorkerDelegate {
    protected long longBuffer = 0;

    protected IntLogWorkerDelegate(Saver saver, MessageDecorator messageDecorator) {
        super(saver, messageDecorator);
    }

    protected void flushOverflowedBuffer(int maxValue, int lastMessage) {
        int overflowRemainder = lastMessage % maxValue;
        longBuffer += overflowRemainder;
        flushBuffer();
        long messageRemainder = lastMessage - overflowRemainder;
        while (messageRemainder >= maxValue) {
            longBuffer += maxValue;
            flushBuffer();
            messageRemainder -= maxValue;
        }
    }

    public void flushBuffer() {
        if (longBuffer != 0) {
            saver.save(messageDecorator.getDecoratedMessage((int)longBuffer));
            longBuffer = 0;
        }
    }
}
