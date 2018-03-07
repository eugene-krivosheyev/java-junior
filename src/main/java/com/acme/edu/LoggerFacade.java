package com.acme.edu;

import com.acme.edu.message.*;

public class LoggerFacade {

    public static void log(byte message) {
        MessageController mess = new MessageController(new ByteMessage(message));
        mess.flush();
        mess.accumulate();
    }
    public static void log(int message) {
        MessageController mess = new MessageController(new IntMessage(message));
        mess.flush();
        mess.accumulate();
    }
    public static void log(char message) {
        MessageController mess = new MessageController(new CharMessage(message));
        mess.flush();
        mess.accumulate();
    }
    public static void log(boolean message) {
        MessageController mess = new MessageController(new BooleanMessage(message));
        mess.flush();
        mess.accumulate();
    }
    public static void log(String message) {
        MessageController mess = new MessageController(new StringMessage(message));
        mess.flush();
        mess.accumulate();
    }
    public static void log(Object message) {
        MessageController mess = new MessageController(new ObjectMessage(message));
        mess.flush();
        mess.accumulate();
    }
    public static void log(String... message){
        MessageController mess = new MessageController(new StringArrayMessage(message));
        mess.flush();
        mess.accumulate();
    }
    public static void log(int... message){
        MessageController mess = new MessageController(new IntArrayMessage(message));
        mess.flush();
        mess.accumulate();
    }
    public static void log(int[][] message) {
        MessageController mess = new MessageController(new IntDdlArrayMessage(message));
        mess.flush();
        mess.accumulate();
    }
    public static void log(int[][][][] message) {
        MessageController mess = new MessageController(new IntQtrArrayMessage(message));
        mess.flush();
        mess.accumulate();
    }
    public static void flush(){

        System.out.println(Flusher.getBuffer());
        System.out.println(Flusher.getCounter());
    }
}
