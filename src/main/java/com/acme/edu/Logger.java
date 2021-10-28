package com.acme.edu;

import message.*;
import net.Connector;
import net.Proxy;

public class Logger {

    private static final Proxy proxy = new Proxy(new Connector());

    private Logger() {

    }

    public static void flush() {
        proxy.send(new FlushMessage());
    }

    public static void log(int integer) {
        proxy.send(new IntMessage(integer));
    }

    public static void log(Integer... integer) {
        proxy.send(new IntArrayMessage(integer));
    }

    public static void log(Integer[]... integer) {
        proxy.send(new Int2dArrayMessage(integer));
    }

    public static void log(byte byteValue) {
        proxy.send(new ByteMessage(byteValue));
    }

    public static void log(String string) {
        proxy.send(new StringMessage(string));
    }

    public static void log(String... string) {
        proxy.send(new StrArrayMessage(string));
    }

    public static void log(Boolean bool) {
        proxy.send(new BooleanMessage(bool));
    }

    public static void log(char symbol) {
        proxy.send(new CharMessage(symbol));
    }

    public static void log(Object object) {
        proxy.send(new ObjectMessage(object));
    }
}
