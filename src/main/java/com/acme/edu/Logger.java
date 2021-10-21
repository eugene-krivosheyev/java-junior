package com.acme.edu;

import buffer.*;
import controller.Controller;
import message.*;

public class Logger {

    private static Controller controller = new Controller();

    public static void flush() {
        controller.getRequest(null, new Buffer());
    }

    public static void log(int integer) {
        controller.getRequest(new IntMessage(integer), new IntBuffer());
    }

    public static void log(Integer... integer) {
        controller.getRequest(new IntArrayMessage(integer), new IntArrayBuffer());
    }

    public static void log(Integer[]... integer) {
        controller.getRequest(new Int2dArrayMessage(integer), new Int2dArrayBuffer());
    }

    public static void log(byte byteValue) {
        controller.getRequest(new IntMessage((int)byteValue), new ByteBuffer());
    }

    public static void log(String string) {
        controller.getRequest(new StringMessage(string), new StrBuffer());
    }

    public static void log(String... string) {
        controller.getRequest(new StrArrayMessage(string), new StrArrayBuffer());
    }

    public static void log(Boolean bool) {
        controller.getRequest(new ObjectMessage(bool), new BoolBuffer("primitive: "));
    }

    public static void log(char symbol) {
        controller.getRequest(new ObjectMessage(symbol), new CharBuffer("char: "));
    }

    public static void log(Object object) {
        controller.getRequest(new ObjectMessage(object), new ObjectBuffer("reference: "));
    }
}
