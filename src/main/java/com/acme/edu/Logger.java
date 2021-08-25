package com.acme.edu;

import com.acme.edu.accumulator.ByteAccumulator;
import com.acme.edu.accumulator.IntAccumulator;
import com.acme.edu.accumulator.StringAccumulator;
import com.acme.edu.message.BooleanMessage;
import com.acme.edu.message.CharMessage;
import com.acme.edu.message.Message;

import java.util.Arrays;

public class Logger {
    private static final IntAccumulator intAccumulator = new IntAccumulator();
    private static final ByteAccumulator byteAccumulator = new ByteAccumulator();
    private static final StringAccumulator stringAccumulator = new StringAccumulator();

    private static final ClassValidator classValidator = new ClassValidator();

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
        if(classValidator.setCurrentClass(message)){
            Logger.flush();
        }

        Message message1 = byteAccumulator.addValueToAccumulator(message);
        if(message1 != null){
            message1.writeMessageToLog();
        }
    }

    public static void log(char message) {
        Message message1 = new CharMessage(message);
        message1.writeMessageToLog();
    }

    public static void log(String message) {
        if(classValidator.setCurrentClass(message)){
            Logger.flush();
        }

        Message message1 = stringAccumulator.accumulateString(message);
        if(message1 != null){
            message1.writeMessageToLog();
        }
    }

    public static void log(String ... messages) {
        Arrays.stream(messages).forEach(Logger::log);
    }

    public static void log(boolean message) {
        Message message1 = new BooleanMessage(message);
        message1.writeMessageToLog();
    }

    public static void log(Object message) {
        Message message1 = new Message(message);
        message1.writeMessageToLog();
    }

    public static void flush() {
        Message stringMessage = stringAccumulator.flush();
        if(stringMessage != null){
            stringMessage.writeMessageToLog();
        }

        Message byteMessage = byteAccumulator.flush();
        if(byteMessage != null){
            byteMessage.writeMessageToLog();
        }

        Message intMessage = intAccumulator.flush();
        if(intMessage != null){
            intMessage.writeMessageToLog();
        }
    }
}
