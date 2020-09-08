package com.acme.edu;

import com.acme.edu.command.IntCommand;
import com.acme.edu.controller.LoggerController;
import com.acme.edu.message.Type;
import com.acme.edu.message.Prefix;
import com.acme.edu.saver.ConsoleSaver;

public class Logger {
    //private static byte byteAccumulator = (byte) 0;

    private static LoggerController loggerController = new LoggerController(new ConsoleSaver());

    public static void log(int message) {
        loggerController.log(new IntCommand(message));
        //setPreviousPrefixAndType(Prefix.PRIMITIVE_PREFIX, Type.INT);
    }

//    public static void log(byte message) {
//        byte diff = (byte) checkNumberAccumulatorOverflow(Byte.MAX_VALUE, byteAccumulator, message);
//        if (Byte.MAX_VALUE - byteAccumulator < message) {
//            byteAccumulator += diff;
//            message -= diff;
//            flush();
//        }
//        byteAccumulator += message;
//        if (previousType != null && !previousType.equals(Type.BYTE)) {
//            flush();
//        }
//        setPreviousPrefixAndType(Prefix.PRIMITIVE_PREFIX, Type.BYTE);
//    }

//    public static void log(char message) {
//        writeMessage(Prefix.CHAR_PREFIX + message);
//    }

    public static void log(String message) {

//        if (message.equals(stringAccumulator)) {
//            stringDuplicates++;
//        } else {
//            stringAccumulator += message;
//        }
//        if (previousType != null && !previousType.equals(Type.STRING)) {
//            flush();
//        }
//        setPreviousPrefixAndType(Prefix.STRING_PREFIX, Type.STRING);
    }


//    public static void log(boolean message) {
//        writeMessage(Prefix.PRIMITIVE_PREFIX + message);
//    }
//
//    public static void log(Object message) {
//        writeMessage(Prefix.REFERENCE_PREFIX + message);
//    }
//
//    public static void log(int[] message) {
//        writeArray(message);
//    }
//
//    public static void log(int[][] message) {
//        writeMatrix(message);
//    }

//    private static String clearStringBuffer() {
//        String buffer = stringAccumulator;
//        if (stringDuplicates != 0) {
//            buffer += " (x" + ++stringDuplicates + ")";
//        }
//        stringAccumulator = "";
//        stringDuplicates = 0;
//        return buffer;
//    }

//    private static String clearByteBuffer() {
//        String buffer = Byte.toString(byteAccumulator);
//        byteAccumulator = (byte) 0;
//        return buffer;
//    }

//    private static void writeMessage(String message) {
//        System.out.println(message);
//    }

//    private static void writeArray(int[] array) {
//        writeMessage(Prefix.ARRAY_PREFIX + buildArrayStr(array));
//    }

//    private static String buildArrayStr(int[] array) {
//        StringBuilder stringBuilder = new StringBuilder("{");
//        for (int i = 0; i < array.length - 1; i++) {
//            stringBuilder.append(array[i] + ", ");
//        }
//        stringBuilder.append(array[array.length - 1]);
//        stringBuilder.append("}");
//        return stringBuilder.toString();
//    }

//    private static void writeMatrix(int[][] matrix) {
//        writeMessage(Prefix.MATRIX_PREFIX + "{");
//        for (int[] array : matrix) {
//            writeMessage(buildArrayStr(array));
//        }
//        writeMessage("}");
//    }
//
//    private static int checkNumberAccumulatorOverflow(int maxValue, int accumulator, int message) {
//        int diff = 0;
//        if (maxValue - accumulator < message) {
//            diff = message - maxValue;
//        }
//        return diff;
//    }

//    private static void setPreviousPrefixAndType(String prefix, String type) {
//        previousPrefix = prefix;
//        previousType = type;
//    }
}
