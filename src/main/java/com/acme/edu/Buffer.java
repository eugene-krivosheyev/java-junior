package com.acme.edu;

import com.acme.edu.comands.PrimitiveCommand;
import com.acme.edu.comands.StringCommand;

public class Buffer {
    private String stringBuffer = "";
    private Integer stringCounter = 0;
    private Integer integerBuffer = 0;
    private LoggerType previousType = null;
    private static Printer printer = new Printer();

    public void save(int message) {
        if (previousType != null && !comparePreviousType(LoggerType.PRIMITIVE)) {
            flushBuffer();
            integerBuffer = message;
            previousType = LoggerType.PRIMITIVE;
            return;
        }
        if ((long) message + integerBuffer > Integer.MAX_VALUE) {
            int temp = message + integerBuffer - Integer.MAX_VALUE;
            integerBuffer = Integer.MAX_VALUE;
            flushBuffer();
            integerBuffer = temp;
        } else if ((long) message + integerBuffer < Integer.MIN_VALUE) {
            int temp = message + integerBuffer - Integer.MIN_VALUE;
            integerBuffer = Integer.MIN_VALUE;
            flushBuffer();
            integerBuffer = temp;
        } else {
            integerBuffer += message;
        }
        previousType = LoggerType.PRIMITIVE;
    }

    public void save(String message) {
        if ((previousType != null && !comparePreviousType(LoggerType.STRING)) ||
                !stringBuffer.equals(message)) {
            flushBuffer();
            stringBuffer = message;
            stringCounter = 1;
            previousType = LoggerType.STRING;
            return;
        }
        stringCounter++;
        previousType = LoggerType.STRING;
    }

    private boolean comparePreviousType(LoggerType currentType) {
        return currentType.equals(previousType);
    }

    public void flushBuffer() {
        String decoratedMessage = "";
        if (LoggerType.PRIMITIVE.equals(previousType)) {
            String message = String.valueOf(integerBuffer);
            decoratedMessage = new PrimitiveCommand(message).decorate();
        }
        if (LoggerType.STRING.equals(previousType)) {
            String message = stringCounter == 1 ? stringBuffer : stringBuffer + " (x" + stringCounter + ")";
            decoratedMessage = new StringCommand(message).decorate();
        }

        //TODO: add more types

        printer.save(decoratedMessage);
        if (!decoratedMessage.contains(String.valueOf(Integer.MAX_VALUE)) &
                !decoratedMessage.contains(String.valueOf(Integer.MIN_VALUE))) {
            clean();
        }
    }

    private void clean() {
        stringBuffer = "";
        stringCounter = 0;
        integerBuffer = 0;
        previousType = null;
    }
}
