package com.acme.edu;


public class Logger {
    private static Buffer buffer = new Buffer();

    public static void log(int message) {
        buffer.save(message);
    }

    public static void log(byte message) {
        Printer.save(Decorator.decoratePrimitive(String.valueOf(message)));
    }

    public static void log(String message) {
        buffer.save(message);
    }

    public static void log(boolean message) {
        Printer.save(Decorator.decoratePrimitive(String.valueOf(message)));
    }

    public static void log(Object message) {
        Printer.save(Decorator.decorateReference(String.valueOf(message)));
    }

    public static void log(char message) {
        Printer.save(Decorator.decorateChar(String.valueOf(message)));
    }

    public static void close() {
        buffer.flushBuffer();
    }
}

class Buffer {
    private String stringBuffer = "";
    private Integer stringCounter = 0;
    private Integer integerBuffer = 0;
    private Types previousType = null;

    public void flushBuffer() {
        String decoratedMessage = "";
        if (Types.PRIMITIVE.equals(previousType)) {
            String message = String.valueOf(integerBuffer);
            decoratedMessage = Decorator.decoratePrimitive(message);
        }
        if (Types.STRING.equals(previousType)) {
            String message = stringCounter == 1 ? stringBuffer : stringBuffer + " (x" + stringCounter + ")";
            decoratedMessage = Decorator.decorateString(message);
        }
        //todo add more types
        Printer.save(decoratedMessage);
        clean();
    }

    private void clean() {
        stringBuffer = "";
        stringCounter = 0;
        integerBuffer = 0;
        previousType = null;
    }

    public void save(int message) {
        if (previousType != null && !comparePreviousType(Types.PRIMITIVE)) {
            flushBuffer();
            integerBuffer = message;
            previousType = Types.PRIMITIVE;
            return;
        }
        integerBuffer += message;
        previousType = Types.PRIMITIVE;
    }

    public void save(String message) {
        if (previousType != null && !comparePreviousType(Types.STRING) || !stringBuffer.equals(message)) {
            flushBuffer();
            stringBuffer = message;
            stringCounter = 1;
            previousType = Types.STRING;
            return;
        }
        stringCounter++;
        previousType = Types.STRING;
    }

    private boolean comparePreviousType(Types currentType) {
        return currentType.equals(previousType);
    }
}
