package com.acme.edu;

import com.acme.edu.type.Type;
import com.acme.edu.type.Prefix;

public class Logger {
    private static String lastType;
    private static String lastPrefix;
    private static int intAcc = 0;
    private static String stringAcc = "";


    private static void writeAcc(String prefix, String type){
        String acc = "";
        switch (type){
            case Type.INT:
                acc = Integer.toString(intAcc);
                intAcc = 0;
                break;
            case Type.STRING:
                acc = stringAcc;
                stringAcc = "";
                break;
        }
        System.out.println(prefix + acc);
    }

    public static void log(int message) {
        intAcc += message;
        if (lastType != null && !lastType.equals(Type.INT)){
            writeAcc(lastPrefix, lastType);
        }
        lastPrefix = Prefix.PRIMITIVE_PREFIX;
        lastType = Type.INT;
    }


    public static void log(byte message) {
        writeMessageWithPrefix(Prefix.PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        writeMessageWithPrefix(Prefix.CHAR_PREFIX + message);
    }

    public static void log(String message) {
        stringAcc += message;
        if (lastType!=null && !lastType.equals(Type.STRING)){
            writeAcc(lastPrefix, lastType);
        }
        lastPrefix = Prefix.STRING_PREFIX;
        lastType = Type.STRING;
    }


    public static void log(boolean message) {
        writeMessageWithPrefix(Prefix.PRIMITIVE_PREFIX + message);
    }

    public static void log(Object message) {
        writeMessageWithPrefix(Prefix.REFERENCE_PREFIX + message);
    }

    public static void writeMessageWithPrefix(String message){
        System.out.println(message);
    }
}
