package com.acme.edu;

import accumulator.*;
import controller.Controller;
import message.*;
import printer.ConsolePrinter;

public class Logger {

    private static Controller controller = new Controller(new FlushAccumulator(), new ConsolePrinter());

    public static void flush() {
        controller.log(new FlushMessage());
    }

    public static void log(int integer) {
        controller.log(new IntMessage(integer));
    }

    public static void log(Integer... integer) {
        controller.log(new IntArrayMessage(integer));
    }

    public static void log(Integer[]... integer) {
        controller.log(new Int2dArrayMessage(integer));
    }

    public static void log(byte byteValue) {
        controller.log(new ByteMessage(byteValue));
    }

    public static void log(String string) {
        controller.log(new StringMessage(string));
    }

    public static void log(String... string) {
        controller.log(new StrArrayMessage(string));
    }

    public static void log(Boolean bool) {
        controller.log(new BooleanMessage(bool));
    }

    public static void log(char symbol) {
        controller.log(new CharMessage(symbol));
    }

    public static void log(Object object) {
        controller.log(new ObjectMessage(object));
    }
}
