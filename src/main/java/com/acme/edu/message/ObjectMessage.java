package com.acme.edu.message;

import com.acme.edu.Flusher;

public class ObjectMessage implements Message{

    private Object message;
    private static boolean objectUsage;
    private static Object objectBuffer;
    private static int objectCounter;

    public ObjectMessage(Object message) {
        this.message = message;
    }

    @Override
    public boolean isUsed() {
        return objectUsage;
    }

    public static Object getObjectBuffer() {
        return objectBuffer;
    }

    public static int getObjectCounter() {
        return objectCounter;
    }

    @Override
    public void accumulate() {
        if (objectBuffer.equals(null)){
            objectUsage = true;
        } else if (objectBuffer.equals(message)) {
            objectCounter++;
            objectUsage = true;
        }else {
            objectUsage = false;
        }
        objectBuffer = message;

        Flusher.setBuffer(objectBuffer);
        Flusher.setUsage(objectUsage);
    }

    @Override
    public void flush(){
        objectBuffer = null;
        objectUsage = false;
        objectCounter = 0;
    }
}
