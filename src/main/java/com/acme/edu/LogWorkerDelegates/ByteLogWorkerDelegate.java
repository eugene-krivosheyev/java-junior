package com.acme.edu.LogWorkerDelegates;

import com.acme.edu.MessageDecorator.MessageDecorator;
import com.acme.edu.Saver.Saver;

public class ByteLogWorkerDelegate extends IntLogWorkerDelegate {
    public ByteLogWorkerDelegate(Saver saver, MessageDecorator messageDecorator) {
        super(saver, messageDecorator);
    }

    public void log(byte message) {
        if (longBuffer + message > Byte.MAX_VALUE) {
            flushOverflowedBuffer(Byte.MAX_VALUE, message);
        } else {
            saver.save(messageDecorator.getDecoratedMessage(message));
        }
    }
}
