package com.acme.edu;

import com.acme.edu.messageOut.Formatter;
import com.acme.edu.messageOut.Printer;
import com.acme.edu.processors.*;

public class Logger {

    private static Printer printer = new Printer();
    private static Formatter formatter = new Formatter();
    private static Stater state = new Stater(Stater.TypeVar.INIT_STATE, Stater.TypeVar.DEFAULT_STATE, 0, null, 1);
    private static Flusher flusher = new Flusher(formatter, printer, state);
    private static ServiceForIntAndByte serviceForIntAndByte = new ServiceForIntAndByte(formatter, printer, state, flusher);
    private static ServiceForString serviceForString = new ServiceForString(formatter, printer, state, flusher);


    public static void log(String... args) {
        for (String arg : args) {
            log(arg);
        }
    }

    public static void log(int... args) {
        formatter.setMessagePrefix("");
        printer.print(formatter.formatMessage(ServiceForSumOfArray.sumOfArray(args)));
    }

    public static void log(int[][] arr) {
        formatter.setMessagePrefix("");
        printer.print(formatter.formatMessage(ServiceForSumOfArray.sumOfArray2D(arr)));
    }

    public static void log(int message) {
        Controller.log(new IntMessage(message));
    }

    public static void log(byte message) {
        Controller.log(new ByteMessage(message));
    }

    public static void log(char message) {
        formatter.setMessagePrefix("char: ");
        printer.print(formatter.formatMessage(message));
    }

    public static void log(String message) {
        state.setType(Stater.TypeVar.STRING_STATE);
        serviceForString.serviceForString(message);
    }

    public static void log(boolean message) {
        formatter.setMessagePrefix("primitive: ");
        printer.print(formatter.formatMessage(message));
    }

    public static void log(Object message) {
        formatter.setMessagePrefix("reference: ");
        printer.print(formatter.formatMessage(message));
    }

    public static void flush() {
        flusher.flush();
    }

}
