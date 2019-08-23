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
            if (stringBuffer[0] != null) { printToConsole(clearBufferStr()); }
            stringBuffer[0] = message;
            counterOfStrings = 1;
        }
    }

    static void addInBuffer(int message) {
        maxOrMinIfOverflow(message, () -> printToConsole(clearBufferInt()), Integer.MAX_VALUE, Integer.MIN_VALUE);
    }


    static void addInBuffer(byte message) {
        maxOrMinIfOverflow(message, () -> printToConsole(clearBufferByte()), Byte.MAX_VALUE, Byte.MIN_VALUE);
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


    private static void maxOrMinIfOverflow(int value, CleanerBuffer cleanerBuffer, int maxValue, int minValue) {
        if(value > 0 && maxValue - value <=  intBuffer[0] && maxValue == Integer.MAX_VALUE && minValue == Integer.MIN_VALUE) { value = maxValue; }
        else if(value < 0 && minValue - value >= intBuffer[0] && maxValue == Integer.MAX_VALUE && minValue == Integer.MIN_VALUE){ value = minValue; }
        else if(value > 0 && maxValue - value <= byteBuffer[0] && maxValue == Byte.MAX_VALUE && minValue == Byte.MIN_VALUE) { value = maxValue; }
        else if(value < 0 && minValue - value >= byteBuffer[0] && maxValue == Byte.MAX_VALUE && minValue == Byte.MIN_VALUE){ value = minValue; }

        if ((value == maxValue || value == minValue) && maxValue == Integer.MAX_VALUE && minValue == Integer.MIN_VALUE) {
            cleanerBuffer.clear();
            intBuffer[0] = value;
        } else if (maxValue == Integer.MAX_VALUE && minValue == Integer.MIN_VALUE) { intBuffer[0] += value;
        } else if ((value == maxValue || value == minValue) && maxValue == Byte.MAX_VALUE && minValue == Byte.MIN_VALUE) {
            cleanerBuffer.clear();
            intBuffer[0] = value;
        }
        else if (maxValue == Byte.MAX_VALUE && minValue == Byte.MIN_VALUE) { intBuffer[0] += value; }
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

    static BufferState getState() { return state; }
}
