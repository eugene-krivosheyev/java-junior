package com.acme.edu.message;

import com.acme.edu.Flusher;
import com.acme.edu.formatters.PrefixFormatter;

public class BooleanMessage implements Message {
    private boolean message;
    private static final String booleanUsage = "BooleanMessage";
    private static boolean booleanBuffer;

    public BooleanMessage(boolean message) {
        this.message = message;
    }

    @Override
    public String isUsed() {
        return booleanUsage;
    }

    @Override
    public void accumulate() {
        Flusher.setUsed("");
        booleanBuffer=message;
        Flusher.setValue(String.valueOf(booleanBuffer));
        Flusher.setPrefix(acceptPrefix(new PrefixFormatter()));
    }
    @Override
    public void flush(){
        booleanBuffer = false;
    }

    @Override
    public String acceptPrefix(PrefixFormatter prefixFormatter) {
        return prefixFormatter.visitBooleanMessage(this);
    }
}
