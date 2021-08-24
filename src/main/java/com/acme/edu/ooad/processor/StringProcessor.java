package com.acme.edu.ooad.processor;

import com.acme.edu.ooad.message.ObjectMessage;
import com.acme.edu.ooad.message.StringMessage;

public class StringProcessor extends Processor {
    private String lastString = "";
    private int repeatableStringCounter;

    @Override
    public ObjectMessage[] flush() {
        StringMessage message = null;
        if (!isEmptyBuffer()) {
            message = new StringMessage(lastString, repeatableStringCounter);
        }
        cleanBuffer();
        return new StringMessage[]{message};
    }

    private void cleanBuffer() {
        repeatableStringCounter = 0;
    }

    private boolean isNewString(String message) {
        return repeatableStringCounter != 0 && !lastString.equals(message);
    }

    private boolean isEmptyBuffer() {
        return repeatableStringCounter == 0 || lastString.equals("");
    }

    public ObjectMessage[] process(String message) {
        ObjectMessage[] result = null;
        if (isNewString(message)) {
            result = flush();
        }

        lastString = message;
        ++repeatableStringCounter;

        return result;
    }

    public ObjectMessage[] process(String... messages) {
        ObjectMessage[][] processArrays = new ObjectMessage[messages.length][];

        int resultLength = 0;
        for (int i = 0; i < messages.length; ++i) {
            processArrays[i] = process(messages[i]);
            resultLength += processArrays[i] == null ? 0 : processArrays[i].length;
        }

        ObjectMessage[] result = new ObjectMessage[resultLength];
        int resultIterator = 0;

        for (ObjectMessage[] processArray : processArrays) {
            if (processArray == null) continue;
            for (ObjectMessage objectMessage : processArray) {
                result[resultIterator] = objectMessage;
                ++resultIterator;
            }
        }

        return result;
    }
}
