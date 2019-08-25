package com.acme.edu;

//Single line
/*
Multi-line comment
 */

import com.acme.edu.Commands.*;
import com.acme.edu.Saver.ConsoleSaver;

import java.util.Objects;

/**
 * JavaDoc comment
 * Class Logger has unnecessarily comment.
 * <strong>bold</strong>
 * @see java.lang.String#String()
 */

public class Logger {
    private static String PREFIX_PRIMITIVE = "primitive: ";
    private static String PREFIX_PRIMITIVES_ARRAY = "primitives array: ";
    private static String PREFIX_CHAR = "char: ";
    private static String PREFIX_STRING = "string: ";
    private static String PREFIX_REFERENCE = "reference: ";

    private static Controller controller = new Controller(new ConsoleSaver());

    public enum LoggingType {
        INT,
        CHAR,
        STRING,
        BYTE,
        BOOLEAN,
        OBJECT,
        INTARRAY,
        NOTHING
    }
    private static int sum = 0;
    private static long maxValue = 0;

    private static int count = 0;
    private static String loggedString = "";

    private static LoggingType lastType = LoggingType.NOTHING;

    public static void log(int message) {
        //makeLog(Integer.toString(message), LoggingType.INT);
        controller.log(new IntCommand(message));

        if(lastType != LoggingType.INT) {
            flush();
        }

        lastType = LoggingType.INT;
    }

    public static void log(byte message) {
        //makeLog(Byte.toString(message), LoggingType.BYTE);
        controller.log(new ByteCommand(message));

        if(lastType != LoggingType.BYTE) {
            flush();
        }

        lastType = LoggingType.BYTE;
    }

    public static void log(int[] message) {
        //makeLog(intArrayToString(message), LoggingType.INTARRAY);
        controller.log(
                new IntArrayCommand(message)
        );
        lastType = LoggingType.INTARRAY;
    }

    public static void log(boolean message) {
        makeLog(Boolean.toString(message), LoggingType.BOOLEAN);
    }

    public static void log(char message) {
        makeLog(Character.toString(message), LoggingType.CHAR);
    }

    public static void log(String message) {
        //makeLog(message, LoggingType.STRING);
        controller.log(new StringCommand(message));
        lastType = LoggingType.STRING;
    }

    public static void log(Object message) {
        makeLog(message.toString(), LoggingType.OBJECT);
    }

    public static void flush(){
        if (lastType == LoggingType.INT || lastType == LoggingType.STRING) {
            controller.flush();
        }
        if (lastType == LoggingType.BYTE){
            //printDecoratedLog(Long.toString(sum), LoggingType.INT);
            //sum = 0;
            //lastType = LoggingType.NOTHING;
            controller.flush();
        }
        if (false) {//lastType == LoggingType.STRING){
            if (count > 1) {
                loggedString += " (x" + count + ")";
            }
            printDecoratedLog(loggedString, LoggingType.STRING);
            count = 0;
            loggedString = "";
            lastType = LoggingType.NOTHING;
        }
    }

    private static String decorateLog(String message, LoggingType type) {
        String prefix = "";
        if (type == LoggingType.INT || type == LoggingType.BYTE || type == LoggingType.BOOLEAN) {
            prefix = PREFIX_PRIMITIVE;
        } else if (type == LoggingType.CHAR) {
            prefix = PREFIX_CHAR;
        } else if (type == LoggingType.STRING) {
            prefix = PREFIX_STRING;
        } else if (type == LoggingType.INTARRAY) {
          prefix = PREFIX_PRIMITIVES_ARRAY;
        } else  {
            prefix = PREFIX_REFERENCE;
        }
        return prefix + message;
    }


    private static void makeLog(String message, LoggingType type) {
        if ((type == LoggingType.INT) || (type == LoggingType.BYTE)) {
            if (type == lastType) {
                int current = Integer.parseInt(message);
                if ((long) current + sum >= maxValue) {
                    flush();
                }
                sum += current;
            } else {
                if (lastType != LoggingType.NOTHING) {
                    flush();
                }
                maxValue = type == LoggingType.INT ? Integer.MAX_VALUE : Byte.MAX_VALUE;
                sum = Integer.parseInt(message);
            }
        } else if (type == LoggingType.STRING){
            if ((type == lastType) && (Objects.equals(message,loggedString))){
                count += 1;
            } else {
                flush();
                loggedString = message;
                count = 1;
            }
        }
        else {
            printDecoratedLog(message, type);
        }
        lastType = type;
    }

    private static void printDecoratedLog(String message, LoggingType type) {
        System.out.println(decorateLog(message, type));
    }

}