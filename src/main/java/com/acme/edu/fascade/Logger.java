package com.acme.edu.fascade;

import com.acme.edu.LoggerController;
import com.acme.edu.decorator.ClassicDecorator;
import com.acme.edu.decorator.LoggerDecorator;
import com.acme.edu.message.*;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.LoggerSaver;

public class Logger {
    private static LoggerController controller = new LoggerController(System.out::println, message -> new ClassicDecorator().visit(message));

    public static void flush() {
        controller.flush();
    }

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }


    public static void log(char message) {
        controller.log(new CharMessage(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

    public static void log(int[] message) { controller.log(new IntArrayMessage(message));}

    public static void log(int[][] message) { controller.log(new IntMatrixMessage(message));}
    public static void log(Object message) {
        controller.log(new ObjectMessage(message));
    }
}
