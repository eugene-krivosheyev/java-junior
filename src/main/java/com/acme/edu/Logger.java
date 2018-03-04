package com.acme.edu;

import com.acme.edu.message.*;

public class Logger {
    public static String preficsPr = new String("primitive: ");
    public static String preficsCh = new String("char: ");
    public static String preficsSt = new String("string: ");
    public static String preficsOb = new String("reference: ");

    public static void log(byte message) {
        Message mess = new ByteMessage(message);
        if (!ByteMessage.isByteUsage()){
            MessageBuffer.flush();
        }
        mess.accumulate();
    }
    public static void log(int message) {
        Message mess = new IntMessage(message);
        if (!IntMessage.isIntUsage()){
            MessageBuffer.flush();
        }
        mess.accumulate();
    }
    public static void log(char message) {
        Message mess = new CharMessage(message);
        if(message!=CharMessage.getCharBuffer()){
            MessageBuffer.flush();
        }
        mess.accumulate();
    }
    public static void log(boolean message) {
        Message mess = new BooleanMessage(message);
        MessageBuffer.flush();
        mess.accumulate();
    }
    public static void log(String message) {
        Message mess = new StringMessage(message);
        if (!message.equals(StringMessage.getStringBuffer())){
            MessageBuffer.flush();
        }
        mess.accumulate();
    }
    public static void log(Object message) {
        Message mess = new ObjectMessage(message);
        if (!message.equals(ObjectMessage.getObjectBuffer())){
            MessageBuffer.flush();
        }
        mess.accumulate();
    }
    public static void log(String... message){
        Message mess = new StringArrayMessage(message);
        MessageBuffer.flush();
        mess.accumulate();
    }
    public static void log(int... message){
        Message mess = new IntArrayMessage(message);
        MessageBuffer.flush();
        mess.accumulate();
    }
    public static void log(int[][] message) {
        Message mess = new IntDdlArrayMessage(message);
        MessageBuffer.flush();
        mess.accumulate();
    }
    public static void log(int[][][][] message) {
        Message mess = new IntQtrArrayMessage(message);
        MessageBuffer.flush();
        mess.accumulate();
    }
    public static void flush(){
        MessageBuffer.flush();
    }
}
