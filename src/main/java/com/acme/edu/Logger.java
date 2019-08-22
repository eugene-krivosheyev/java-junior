package com.acme.edu;

public class Logger {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String REFERENCE_PREFIX = "reference: ";

    private static final String PRIMITIVE_PREFIX_FOR_ARRAY = "primitives array: ";
    private static final String PRIMITIVE_PREFIX_FOR_MATRIX= "primitives matrix: ";

    private static byte[] byteBuffer = new byte[1];
    private static int[] intBuffer = new int[1];
    private static String[] stringBuffer = new String[1];

    private static int counterOfStrings = 0;

    private static Buffer_State state = Buffer_State.NONE;

    // -------------- METHODS FOR LOG ------------------

    public static void log(Object message) { decorateString(REFERENCE_PREFIX, message); }

    public static void log(char message) {
       decorateString(CHAR_PREFIX, message);
    }

    public static void log(boolean message) {
        decorateString(PRIMITIVE_PREFIX, message);
    }

    public static void log(byte message) {
        if(state != Buffer_State.BYTE) {
            changeState(Buffer_State.BYTE);
        }
        addInBuffer(message);
        decorateString(PRIMITIVE_PREFIX, message);
    }

    public static void log(int message) {
        if(state != Buffer_State.INT) {
            changeState(Buffer_State.INT);
        }
        addInBuffer(message);
        decorateString(PRIMITIVE_PREFIX, message);
    }

    public static void log(String message) {
        if(state != Buffer_State.STR) {
            changeState(Buffer_State.STR);
        }
        addInBuffer(message);
        decorateString(STRING_PREFIX, message);
    }

    public static void log(int [] array) {
        System.out.println(PRIMITIVE_PREFIX_FOR_ARRAY + decorateArray(array));
    }

    public static void log(int [][] array) {
        System.out.println(PRIMITIVE_PREFIX_FOR_MATRIX + decorateArray(array));
    }

    // -------------- DECORATE ARRAY ------------------

    private static String decorateArray(int [] array) {
        StringBuilder result = new StringBuilder("{");
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1)  {
                result.append(", ");
            }
        }
        return result + "}\n";
    }

    private static String decorateArray(int [][] array) {
        StringBuilder result = new StringBuilder("{\n");
        for (int i = 0; i < array.length; i++) {
            result.append("{");
            for (int j = 0; j < array[i].length; j++) {
                result.append(array[i][j]);
                if (j < array[i].length - 1) {
                    result.append(", ");
                }
            }
            result.append("}\n");
        }
        return result + "}\n";
    }

    // -------------- ADD BUFFER ------------------

    private static void addInBuffer(String message) {
        if(message.equals(stringBuffer[0])) {
            counterOfStrings++;
        }
        else {
            if (stringBuffer[0] != null) {
                clearBufferStr();
            }
            stringBuffer[0] = message;
            counterOfStrings = 1;
        }
    }

    private static void addInBuffer(int message) {
        int result = maxOrMinIfOverflow(message);
        if (result == Integer.MAX_VALUE || result == Integer.MIN_VALUE) {
            clearBufferInt();
            intBuffer[0] = result;
        }
        else {
            intBuffer[0] += result;
        }
    }

    private static void addInBuffer(byte message) {
        byte result = maxOrMinIfOverflow(message);
        if (result == Byte.MAX_VALUE || result == Byte.MIN_VALUE) {
            clearBufferInt();
            byteBuffer[0] = result;
        }
        else {
            byteBuffer[0] += result;
        }
    }

    // -------------- DECORATE STRING ------------------

    private static void decorateString(String prefix, Object message) {
        System.out.println(prefix + message);
    }

    // -------------- CLEAR METHODS ------------------

    private static void clearBufferByte() {
        System.out.println(byteBuffer[0]);
        byteBuffer[0] = 0;
    }

    private static void clearBufferStr() {
        if(counterOfStrings > 1) {
            System.out.println(stringBuffer[0] + " (x" + counterOfStrings + ")");
        }
        else {
            System.out.println(stringBuffer[0]);
        }
        stringBuffer[0] = null;
        counterOfStrings = 0;
    }

    private static void clearBufferInt() {
        System.out.println(intBuffer[0]);
        intBuffer[0] = 0;
    }

    // -------------- CHANGE STATE------------------

    private static void changeState(Buffer_State newState) {
        switch (state){
            case BYTE:
                clearBufferByte();
                break;
            case INT:
                clearBufferInt();
                break;
            case STR:
                clearBufferStr();
                break;
            default:
                break;
        }
        state = newState;
    }

    // -------------- CHECK OVERFLOW ------------------

    private static int maxOrMinIfOverflow(int value) {
        if(value > 0 && Integer.MAX_VALUE - value <= intBuffer[0]) {
            return Integer.MAX_VALUE;
        }
        else if(value < 0 && Integer.MIN_VALUE - value >= intBuffer[0]){
            return Integer.MIN_VALUE;
        }
        return value;
    }

    private static byte maxOrMinIfOverflow(byte value) {
        if(value > 0 && Byte.MAX_VALUE - value <= byteBuffer[0]) {
            return Byte.MAX_VALUE;
        }
        else if(value < 0 && Byte.MIN_VALUE - value >= byteBuffer[0]){
            return Byte.MIN_VALUE;
        }
        return value;
    }

    // -------------- CLOSE------------------

    public static void closeBuffer() { changeState(Buffer_State.NONE); }
}

enum Buffer_State {
    BYTE,
    INT,
    STR,
    NONE
}

