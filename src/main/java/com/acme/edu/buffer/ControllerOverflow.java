package com.acme.edu.buffer;


class ControllerOverflow {

   static void controlOverflow(int value, CleanerBuffer cleanerBuffer, int[] buffer) {
        if(value > 0 && Integer.MAX_VALUE - value <=  buffer[0]) { value = Integer.MAX_VALUE; }
        else if(value < 0 && Integer.MIN_VALUE - value >= buffer[0]){ value = Integer.MIN_VALUE; }

        if (value == Integer.MAX_VALUE || value == Integer.MIN_VALUE) {
            cleanerBuffer.clear();
            buffer[0] = value;
        } else { buffer[0] += value; }
    }



    static void controlOverflow(byte value, CleanerBuffer cleanerBuffer, byte[] buffer) {
        if(value > 0 && Byte.MAX_VALUE - value <=  buffer[0]) { value = Byte.MAX_VALUE; }
        else if(value < 0 && Byte.MIN_VALUE - value >= buffer[0]){ value = Byte.MIN_VALUE; }

        if (value == Byte.MAX_VALUE || value == Byte.MIN_VALUE) {
            cleanerBuffer.clear();
            buffer[0] = value;
        } else { buffer[0] += value; }
    }
}
