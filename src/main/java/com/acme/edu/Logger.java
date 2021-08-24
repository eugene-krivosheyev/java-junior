package com.acme.edu;

import com.acme.edu.accumulator.IntAccumulator;
import com.acme.edu.message.BooleanMessage;
import com.acme.edu.message.CharMessage;
import com.acme.edu.message.Message;

import java.util.Arrays;
import java.util.Objects;

public class Logger {
    private static final IntAccumulator intAccumulator = new IntAccumulator();

    private static final ClassValidator classValidator = new ClassValidator();

    private static Integer byteAccumulator = null;
    private static String prevString;
    private static int stringCounter = 0;

    public static void log(int message) {
        if(classValidator.setCurrentClass(message)){
            Logger.flush();
        }

        Message message1 = intAccumulator.addValueToAccumulator(message);
        if(message1 != null){
            message1.writeMessageToLog();
        }
    }

    public static void log(int ... messages) {
        Arrays.stream(messages).forEach(Logger::log);
    }

    public static void log(byte message) {
        initLogWriting(Prefix.PRIMITIVE, message);
    }

    public static void log(char message) {
        Message message1 = new CharMessage(message);
        message1.writeMessageToLog();
    }

    public static void log(String message) {
        initLogWriting(Prefix.STRING, message);
    }

    public static void log(String ... messages) {
        Arrays.stream(messages)
                .forEach(message -> initLogWriting(Prefix.STRING, message));
    }

    public static void log(boolean message) {
        Message message1 = new BooleanMessage(message);
        message1.writeMessageToLog();
    }

    public static void log(Object message) {
        Message message1 = new Message(message);
        message1.writeMessageToLog();
    }

    private static void initLogWriting(Prefix prefix, Object message) {
        Class<?> currentClass = message.getClass();

        if (classValidator.setCurrentClass(message)) {
            flush();
        }

        if (currentClass.equals(String.class)) {
            logString(message.toString());
        } else if (currentClass.equals(Byte.class)) {
            logByte((byte) message);
        } else {
            writeMessageToLog(prefix, message);
        }
    }

    private static void logString(String message) {

        if (Objects.equals(message, prevString)) {
            stringCounter++;
        } else {
            if (stringCounter != 0) {
                flush();
            }

            stringCounter = 1;
            prevString = message;
        }
    }

    private static void logByte(byte input) {
        if (byteAccumulator != null) {
            byteAccumulator += input;
        } else {
            byteAccumulator = (int) input;
        }

        if (byteAccumulator >= Byte.MAX_VALUE) {
            removeByteOverflow(Byte.MAX_VALUE);
        } else if (byteAccumulator <= Byte.MIN_VALUE) {
            removeByteOverflow(Byte.MIN_VALUE);
        }
    }

    private static void removeByteOverflow(int value) {
        writeMessageToLog(Prefix.PRIMITIVE, value);
        byteAccumulator = byteAccumulator - value == 0 ? null : byteAccumulator - value;
    }

    public static void flush() {
        if (prevString != null) {
            if (stringCounter == 1) {
                writeMessageToLog(Prefix.STRING, prevString);
            } else {
                writeMessageToLog(Prefix.STRING, prevString, stringCounter);
            }

            prevString = null;
            stringCounter = 0;
        }

        if (byteAccumulator != null) {
            writeMessageToLog(Prefix.PRIMITIVE, byteAccumulator);
            byteAccumulator = null;
        }

        Message message1 = intAccumulator.flush();
        if(message1 != null){
            message1.writeMessageToLog();
        }
    }

    private static void writeMessageToLog(Prefix prefix, Object message) {
        logToConsole(String.format("%s %s%n", prefix.value, message.toString()));
    }

    private static void writeMessageToLog(Prefix prefix, Object message, int counter) {
        logToConsole(String.format("%s %s (x%d)%n", prefix.value, message.toString(), counter));
    }

    private static void logToConsole(String report) {
        System.out.print(report);
    }
}
