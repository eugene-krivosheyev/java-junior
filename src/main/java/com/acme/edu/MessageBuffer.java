package com.acme.edu;

import com.acme.edu.message.*;

public class MessageBuffer {

    public static void flush(){
        if(IntMessage.isIntUsage()){
            System.out.println(IntMessage.getIntBuffer()); //need to refactor
            IntMessage.flush();
        }
        if (ByteMessage.isByteUsage()){
            System.out.println(ByteMessage.getByteBuffer()); //need to refactor
            ByteMessage.flush();
        }
        if(CharMessage.isCharUsage()){
            System.out.println(CharMessage.getCharBuffer()); //need to refactor
            CharMessage.flush();
        }
        if (BooleanMessage.isBooleanUsage()){
            System.out.println(BooleanMessage.isBooleanBuffer());
            BooleanMessage.flush();
        }
        if (StringMessage.isStringUsage()){
            System.out.println(StringMessage.getStringBuffer());
            StringMessage.flush();
        }
        if (ObjectMessage.isObjectUsage()){
            System.out.println(ObjectMessage.getObjectBuffer());
            ObjectMessage.flush();
        }
        if (IntArrayMessage.isIntArrayUsage()){
            IntArrayMessage.flush();
        }
        if (StringArrayMessage.isStringArrayUsage()){
            StringArrayMessage.flush();
        }
        if (IntDdlArrayMessage.isIntDblArrayUsage()){
            IntDdlArrayMessage.flush();
        }
        if (IntQtrArrayMessage.isIntQtrArrayUsage()){
            IntQtrArrayMessage.flush();
        }
    }
    public static void overFlush(byte needToFlush){
        System.out.println(needToFlush);
    }
    public static void overFlush(int needToFlush){
        System.out.println(needToFlush);
    }
}
