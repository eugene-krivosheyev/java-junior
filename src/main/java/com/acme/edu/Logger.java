package com.acme.edu;

import com.acme.edu.api.LoggerController;
import com.acme.edu.api.message.*;
import com.acme.edu.api.saver.ConsoleSaver;

import java.util.Arrays;

public class Logger {
    private static final LoggerController service = new LoggerController(new ConsoleSaver());

    private Logger() {
    }

    public static void log(int message) {
        service.log(new IntegerMessage(message));
    }

    public static void log(byte message) {
        service.log(new ByteMessage(message));
    }

    public static void log(char message) {
        service.log(new CharacterMessage(message));
        flush();
    }

    public static void log(String message) {
        try {
            service.log(new StringMessage(message));
        } catch (NullPointerException exception) {
            System.out.print(exception.getMessage());
        }
    }

    public static void log(String... strings) {
        try {
            Arrays.stream(strings).forEach(str -> service.log(new StringMessage(str)));
        } catch (NullPointerException exception) {
            System.out.print(exception.getMessage());
        }
    }

    /**
     * @param printAsArray boolean toggle to clarify how integers should be logged
     */
    public static void log(boolean printAsArray, int... integers) {
        try {
            service.log(new PrimitiveArrayMessage(integers, printAsArray));
            flush();
        }
        catch (NullPointerException exception){
            System.out.print(exception.getMessage());
        }
    }

    /**
     * Default way to log array of integers is to log sum
     */
    public static void log(int... integers) {
        try {
            service.log(new PrimitiveArrayMessage(integers));
            flush();
        }
        catch (NullPointerException exception){
            System.out.print(exception.getMessage());
        }
    }

    /**
     * @param printAsArray boolean toggle to clarify how 2D array of integers should be logged
     */
    public static void log(boolean printAsArray, int[][] integers) {
        try {
            service.log(new PrimitiveMatrixMessage(integers, printAsArray));
            flush();
        }catch (NullPointerException exception){
            System.out.print(exception.getMessage());
        }
    }

    /**
     * Default way to log 2D array of integers is to log sum
     */
    public static void log(int[][] integers) {
        try {
            service.log(new PrimitiveMatrixMessage(integers));
            flush();
        }catch (NullPointerException exception){
            System.out.print(exception.getMessage());
        }
    }

    public static void log(boolean message) {
        service.log(new BooleanMessage(message));
        flush();
    }

    public static void log(Object message) {
        try {
            service.log(new ObjectRefMessage(message.toString()));
            flush();
        } catch (NullPointerException exception) {
            System.out.print("Insert notNull Object\n");
        }
    }

    public static void flush() {
        service.flush();
    }
}
