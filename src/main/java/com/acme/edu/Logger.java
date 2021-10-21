package com.acme.edu;

import buffer.*;
import controller.Controller;
import message.*;

public class Logger {

    private static Controller controller = new Controller();

    public static void flush() {
        controller.log(null, new Buffer());
    }

    public static void log(int integer) {
        controller.log(new IntMessage(integer), new IntBuffer());
    }

    public static void log(Integer... integer) {
        controller.log(new IntArrayMessage(integer), new IntArrayBuffer());
    }

    public static void log(Integer[]... integer) {
        controller.log(new Int2dArrayMessage(integer), new Int2dArrayBuffer());
    }

    public static void log(byte byteValue) {
        controller.log(new IntMessage((int)byteValue), new ByteBuffer());
    }

    public static void log(String string) {
        controller.log(new StringMessage(string), new StrBuffer());
    }

    public static void log(String... string) {
        controller.log(new StrArrayMessage(string), new StrArrayBuffer());
    }

    public static void log(Boolean bool) {
        controller.log(new ObjectMessage(bool), new BoolBuffer("primitive: "));
    }

    public static void log(char symbol) {
        controller.log(new ObjectMessage(symbol), new CharBuffer("char: "));
    }

    public static void log(Object object) {
        controller.log(new ObjectMessage(object), new ObjectBuffer("reference: "));
    }
}
