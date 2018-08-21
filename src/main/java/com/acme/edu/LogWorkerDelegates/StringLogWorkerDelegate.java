package com.acme.edu.LogWorkerDelegates;

import com.acme.edu.MessageDecorator.MessageDecorator;
import com.acme.edu.Saver.Saver;

public class StringLogWorkerDelegate extends LogWorkerDelegate {
    String stringBuffer;
    int stringBufferCounter;

    public StringLogWorkerDelegate(Saver saver, MessageDecorator messageDecorator) {
        super(saver, messageDecorator);
    }

    public void log (String message) {
        if (stringBuffer == null) {
            stringBuffer = message;
            stringBufferCounter += 1;
        } else if (stringBuffer.equals(message)) {
            stringBufferCounter += 1;
        } else {
            flushBuffer();
            stringBuffer = message;
            stringBufferCounter += 1;
        }
    }

    public void flushBuffer() {
        if (stringBuffer != null) {
            String decoratedString = "string: " + stringBuffer;
            if (stringBufferCounter > 1) {
                decoratedString += " (x" + stringBufferCounter + ")";
            }
            saver.save(messageDecorator.getDecoratedMessage(decoratedString));
            stringBufferCounter = 0;
            stringBuffer = null;
        }
    }
}
