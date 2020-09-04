package com.acme.edu;

import com.acme.edu.type.Type;
import com.acme.edu.type.Prefix;

public class Logger {
    private static String lastType;
    private static String lastPrefix;
    private static int intAcc = 0;
    private static String stringAcc = "";
    private static int stringDups = 0;
    private static byte byteAcc = (byte) 0;


    public static void flush() {
        String acc = "";
        switch (lastType) {
            case Type.INT:
                acc = Integer.toString(intAcc);
                intAcc = 0;
                break;
            case Type.STRING:
                acc = stringAcc;
                if (stringDups != 0) {
                    acc += " (x" + ++stringDups + ")";
                }
                stringAcc = "";
                stringDups = 0;
                break;
            case Type.BYTE:
                acc = Byte.toString(byteAcc);
                byteAcc = (byte) 0;
                break;
        }
        System.out.println(lastPrefix + acc);
        lastPrefix = null;
        lastType = null;
    }

    public static void log(int message) {
        if (Integer.MAX_VALUE - intAcc < message) {
            int diff = message - Integer.MAX_VALUE;
            intAcc += diff;
            message -= diff;
            flush();
        }
        intAcc += message;
        if (lastType != null && !lastType.equals(Type.INT)) {
            flush();
        }
        lastPrefix = Prefix.PRIMITIVE_PREFIX;
        lastType = Type.INT;
    }

    public static void log(int[] message) {
        writeArray(message);
    }

    private static void writeArray(int[] array) {
        StringBuilder stringBuilder = new StringBuilder(Prefix.ARRAY_PREFIX + "{");
        for (int i = 0; i < array.length - 1; i++) {
            stringBuilder.append(array[i] + ", ");
        }
        stringBuilder.append(array[array.length - 1]);
        stringBuilder.append("}");
        writeMessage(stringBuilder.toString());
    }

    public static void log(byte message) {
        if (Byte.MAX_VALUE - byteAcc < message) {
            byte diff = (byte) (message - Byte.MAX_VALUE);
            byteAcc += diff;
            message -= diff;
            flush();
        }
        byteAcc += message;
        if (lastType != null && !lastType.equals(Type.BYTE)) {
            flush();
        }
        lastPrefix = Prefix.PRIMITIVE_PREFIX;
        lastType = Type.BYTE;
    }

    public static void log(char message) {
        writeMessage(Prefix.CHAR_PREFIX + message);
    }

    public static void log(String message) {
        if (message.equals(stringAcc)) {
            stringDups++;
        } else {
            stringAcc += message;
        }
        if (lastType != null && !lastType.equals(Type.STRING)) {
            flush();
        }
        lastPrefix = Prefix.STRING_PREFIX;
        lastType = Type.STRING;
    }


    public static void log(boolean message) {
        writeMessage(Prefix.PRIMITIVE_PREFIX + message);
    }

    public static void log(Object message) {
        writeMessage(Prefix.REFERENCE_PREFIX + message);
    }

    private static void writeMessage(String message) {
        System.out.println(message);
    }
}
