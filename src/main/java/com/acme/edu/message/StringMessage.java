package com.acme.edu.message;

import com.acme.edu.Flusher;
import com.acme.edu.formatters.PrefixFormatter;

public class StringMessage implements Message {
    private String message;
    private static final String stringUsage= "StringMessage";
    private static String stringBuffer;
    private static int stringCounter;

    public StringMessage (String message) {
        this.message = message;
    }
    @Override
    public String isUsed() {
        return stringUsage;
    }

    @Override
    public void accumulate() {
        if (stringBuffer == null ){
            Flusher.setUsed(stringUsage);
        } else {
            if (stringBuffer.equals(message)) {
                stringCounter++;
                Flusher.setUsed(stringUsage);
            } else {
                Flusher.flush();
                flush();
            }
        }
        stringBuffer = message;
        if (stringCounter ==0){
            Flusher.setValue(stringBuffer);
        }else {
            Flusher.setValue(stringBuffer + " (x" + String.valueOf(stringCounter+1) + ")");
        }
        Flusher.setPrefix(acceptPrefix(new PrefixFormatter()));
    }
    @Override
    public void flush(){
        stringBuffer = null;
        stringCounter = 0;
    }

    @Override
    public String acceptPrefix(PrefixFormatter prefixFormatter) {
        return prefixFormatter.visitStringMessage(this);
    }
}
