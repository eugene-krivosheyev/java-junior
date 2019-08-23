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
        ControllerOverflow.controlOverflow(message, () -> printToConsole(clearBufferInt()), intBuffer);
    }


    static void addInBuffer(byte message) {
        ControllerOverflow.controlOverflow(message, () -> printToConsole(clearBufferByte()), byteBuffer);
    }

    private static Byte clearBufferByte() {
        Byte result = byteBuffer[0];
        byteBuffer[0] = 0;
        return result;
    }

    private static String clearBufferStr() {
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

    private static int clearBufferInt() {
        int result = intBuffer[0];
        intBuffer[0] = 0;
        return result;
    }

    private static void setState(BufferState newState) {
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

    private static BufferState getState() { return state; }

    static void changeState(BufferState state) {
        if(getState() != state) setState(state);
    }
}
