package com.acme.edu.message;

import com.acme.edu.Flusher;
import com.acme.edu.formatters.PrefixFormatter;

public class ObjectMessage implements Message{

    private Object message;
    private static String objectUsage = "ObjectMessage";
    private static Object objectBuffer;
    private static int objectCounter;

    public ObjectMessage(Object message) {
        this.message = message;
    }

    @Override
    public String isUsed() {
        return objectUsage;
    }

    @Override
    public void accumulate() {
        if (objectBuffer==null){
            Flusher.setUsed(objectUsage);
        } else if (objectBuffer.equals(message)) {
            objectCounter++;
            Flusher.setUsed(objectUsage);
        }else {
            Flusher.flush();
            flush();
        }
        objectBuffer = message;
        if (objectCounter==0){
            Flusher.setValue(objectBuffer.toString());
        } else {
            Flusher.setValue(objectBuffer.toString() + " (x" + String.valueOf(objectCounter+1) + ")");
        }
        Flusher.setPrefix(acceptPrefix(new PrefixFormatter()));
    }
    @Override
    public void flush(){
        objectBuffer = null;
        objectCounter = 0;
    }
    @Override
    public String acceptPrefix(PrefixFormatter prefixFormatter) {
        return prefixFormatter.visitObjectMessage(this);
    }
}
