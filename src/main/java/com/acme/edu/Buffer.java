package com.acme.edu;

class Buffer {

    private static byte[] byteBuffer = new byte[1];
    private static int[] intBuffer = new int[1];
    private static String[] stringBuffer = new String[1];

    private static int counterOfStrings = 0;
    // -------------- ADD BUFFER ------------------

    static void addInBuffer(String message) {
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

    static void addInBuffer(int message) {
        int result = maxOrMinIfOverflow(message);
        if (result == Integer.MAX_VALUE || result == Integer.MIN_VALUE) {
            clearBufferInt();
            intBuffer[0] = result;
        }
        else {
            intBuffer[0] += result;
        }
    }

    static void addInBuffer(byte message) {
        byte result = maxOrMinIfOverflow(message);
        if (result == Byte.MAX_VALUE || result == Byte.MIN_VALUE) {
            clearBufferByte();
            byteBuffer[0] = result;
        }
        else {
            byteBuffer[0] += result;
        }
    }

    // -------------- CLEAR METHODS ------------------

    static void clearBufferByte() {
        System.out.println(byteBuffer[0]);
        byteBuffer[0] = 0;
    }

    static void clearBufferStr() {
        if(counterOfStrings > 1) {
            System.out.println(stringBuffer[0] + " (x" + counterOfStrings + ")");
        }
        else {
            System.out.println(stringBuffer[0]);
        }
        stringBuffer[0] = null;
        counterOfStrings = 0;
    }

    static void clearBufferInt() {
        System.out.println(intBuffer[0]);
        intBuffer[0] = 0;
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


}
