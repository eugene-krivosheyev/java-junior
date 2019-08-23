package com.acme.edu;

import static com.acme.edu.Saver.printToConsole;

class Buffer {

    private static byte[] byteBuffer = new byte[1];
    private static int[] intBuffer = new int[1];
    private static String[] stringBuffer = new String[1];

    private static int counterOfStrings = 0;

    private static BufferState state = BufferState.NONE;

    static void addInBuffer(String message) {
        if(message.equals(stringBuffer[0])) {
            counterOfStrings++;
        }
        else {
            if (stringBuffer[0] != null) {
                printToConsole(clearBufferStr());
            }
            stringBuffer[0] = message;
            counterOfStrings = 1;
        }
    }

    static void addInBuffer(int message) {
        maxOrMinIfOverflow(message, () -> printToConsole(clearBufferInt()), intBuffer);
    }


    static void addInBuffer(byte message) {
        maxOrMinIfOverflow(message, () -> printToConsole(clearBufferByte()), byteBuffer);
    }

    static Byte clearBufferByte() {
        Byte result = byteBuffer[0];
        byteBuffer[0] = 0;
        return result;
    }

    static String clearBufferStr() {
        String result;
        if(counterOfStrings > 1) {
            result = stringBuffer[0] + " (x" + counterOfStrings + ")";
        }
        else {
            result = stringBuffer[0];
        }
        stringBuffer[0] = null;
        counterOfStrings = 0;
        return result;
    }

    static int clearBufferInt() {
        int result = intBuffer[0];
        intBuffer[0] = 0;
        return result;
    }


    private static void maxOrMinIfOverflow(int value, CleanerBuffer cleanerBuffer, int[] intBuffer) {
        if(value > 0 && Integer.MAX_VALUE - value <= intBuffer[0]) {
            value = Integer.MAX_VALUE;
        }
        else if(value < 0 && Integer.MIN_VALUE - value >= intBuffer[0]){
            value = Integer.MIN_VALUE;
        }

        if (value == Integer.MAX_VALUE || value == Integer.MIN_VALUE) {
            cleanerBuffer.clear();
            intBuffer[0] = value;
        }
        else {
            intBuffer[0] += value;
        }
    }

    private static void maxOrMinIfOverflow(byte value, CleanerBuffer cleanerBuffer, byte[] byteBuffer) {
        if(value > 0 && Byte.MAX_VALUE - value <= byteBuffer[0]) {
            value = Byte.MAX_VALUE;
        }
        else if(value < 0 && Byte.MIN_VALUE - value >= byteBuffer[0]){
            value = Byte.MIN_VALUE;
        }

        if (value == Byte.MAX_VALUE || value == Byte.MIN_VALUE) {
            cleanerBuffer.clear();
            byteBuffer[0] = value;
        }
        else {
            byteBuffer[0] += value;
        }
    }

    static void setState(BufferState newState) {
        switch (state){
            case BYTE:
                printToConsole(clearBufferByte());
                break;
            case INT:
                printToConsole(clearBufferInt());
                break;
            case STR:
                printToConsole(clearBufferStr());
                break;
            default:
                break;
        }
        state = newState;
    }

    static BufferState getState() {
        return state;
    }

    public static void main(String[] args) {

    }
}
