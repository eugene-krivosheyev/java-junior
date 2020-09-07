package com.acme.edu.message;

public class ByteCommand extends LogMessage {
    static byte byteBuffer = 0;
    public static boolean byteFlag = false;
    private byte value;
    final static String
            PREFIX_PRIMITIVE = "primitive: ";

    public ByteCommand (byte message){
        this.value = message;
    }

    @Override
    public String getDecoratedSelf(){
        return PREFIX_PRIMITIVE + value;
    }

    @Override
    public void reset(){
        byteFlag = false;
        byteBuffer = 0;
    }

    public boolean checkFlush() {
        int sumCheck = value + byteBuffer;
        return sumCheck >= Byte.MAX_VALUE;
    }
}
