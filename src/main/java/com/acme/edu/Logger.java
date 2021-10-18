package com.acme.edu;

public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String OBJECT_PREFIX = "reference: ";
    public static final String MATRIX_PREFIX = "primitives matrix: ";
    public static boolean intAccIsNotEmpty = false;
    private static long intAccumulator = 0;
    public static boolean byteAccIsNotEmpty = false;
    public static boolean allowToHandleMatrix = true;
    private static int byteAccumulator = 0;
    private static String currentString;
    private static String prevString;
    private static int strRepeatCounter = 1;


    public static void log(int message) { output(Type.INTEGER,PRIMITIVE_PREFIX, message); }

    public static void log(byte message) { output(Type.BYTE,PRIMITIVE_PREFIX, message); }

    public static void log(char message) { output(Type.CHARACTER, CHAR_PREFIX, message); }

    public static void log(String message) { output(Type.STRING,STRING_PREFIX, message); }

    public static void log(boolean message) { output(Type.BOOLEAN,PRIMITIVE_PREFIX, message); }

    public static void log(Object message) { output(Type.OBJECT,OBJECT_PREFIX, message); }

    public static void log(int... message) {
        output(Type.INTARRAY, PRIMITIVE_PREFIX, message);
    }

    public static void log(int[][] message) {
        output(Type.INT2DARRAY, MATRIX_PREFIX, message);
    }

    private static void output(Type type, String prefix, Object message) {
        switch (type.getValue()) {
            case ("int"):
                accumulator((int) message);
                break;
            case ("byte"):
                accumulator((byte) message);
                break;
            case ("str"):
//                stringHandler((String) message);
                break;
            case ("intarray"):
                for (int i : (int[]) message) {
                    log(i);
                }
                break;
            case ("int2darray"):
                for (int[] i : (int[][]) message) {
                    for (int j : i) {
                        log(j);
                    }
                }
                break;
            default:
                System.out.println(prefix + message);
                break;
        }
    }

    private static void accumulator(int i) {
        intAccumulator += i;
        intAccIsNotEmpty = true;
    }

    private static void accumulator(byte b) {
        byteAccumulator += b;
        byteAccIsNotEmpty = true;
    }

    public static void flush() {
        if (allowToHandleMatrix) {
            System.out.println(MATRIX_PREFIX + intAccumulator);
        }else if (intAccIsNotEmpty) {
            System.out.println(PRIMITIVE_PREFIX + intAccumulator);
            intAccumulator = 0;
            intAccIsNotEmpty = false;
        }
        if (byteAccIsNotEmpty) {
            System.out.println(PRIMITIVE_PREFIX + byteAccumulator);
            byteAccumulator = 0;
            byteAccIsNotEmpty = false;
        }

    }

//    public static void stringHandler(String message) { //str 2
//        if (currentString != message && currentString != null) { //
//            if (strRepeatCounter == 1) {
//                System.out.println(currentString);
//
//                currentString = message;
//                strRepeatCounter = 1;
//            } else {
//                if (strRepeatCounter > 1) {
//                    System.out.println(currentString + " (x" + strRepeatCounter + ")");
//                }
//                currentString = message;
//                strRepeatCounter = 1;
//            }
//
//        } else if (currentString == message) {
//            if (strRepeatCounter == 1) {
//                System.out.println(prevString);
//            } else {
//                System.out.println(prevString + " (x" + strRepeatCounter + ")");
//            }
//            strRepeatCounter += 1;
//        } else if (currentString != message && currentString == null) { //get here on 1st iteration
//            currentString = message;
//        }
//
//
//    }


    enum Type {
        INTEGER("int"),
        BYTE("byte"),
        STRING("str"),
        CHARACTER("char"),
        OBJECT("object"),
        BOOLEAN("bool"),
        INTARRAY("intarray"),
        INT2DARRAY("int2darray");


        private String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }
}


/*
public static void stringHandler(String message) { //str 2
        if (currentString != message && currentString != null) { //if str 1 != str 2
            if (strRepeatCounter == 1) {
                System.out.println(currentString);

                currentString = message;
                strRepeatCounter = 1;
            } else {
                if (strRepeatCounter > 1) {
                    System.out.println(currentString + " (x" + strRepeatCounter + ")");
                }
                currentString = message;
                strRepeatCounter = 1;
            }

        } else if (currentString == message) {
//            if (strRepeatCounter == 1) {
//                System.out.println(prevString);
//            } else {
//                System.out.println(prevString + " (x" + strRepeatCounter + ")");
//            }
            strRepeatCounter += 1;
        } else if (currentString != message && currentString == null) {
            currentString = message;
        }


    }
 */