package com.acme.edu.message;

import com.acme.edu.Flusher;
import com.acme.edu.formatters.PrefixFormatter;

public class CharMessage implements Message {

    private char message;
    private static final String charUsage = "CharMessage";
    private static char charBuffer;
    private static int charCounter;

    public CharMessage(char message) {
        this.message = message;
    }

    @Override
    public String isUsed() {
        return charUsage;
    }

    @Override
    public void accumulate() {
        if (charBuffer == '\0') {
            Flusher.setUsed(charUsage);
        } else if (charBuffer == message) {
            charCounter++;
            Flusher.setUsed(charUsage);
        }
        charBuffer = message;

        if (charCounter == 0) {
            Flusher.setValue(String.valueOf(charBuffer));
        } else {
            Flusher.setValue(String.valueOf(charBuffer) + " (x" + String.valueOf(charCounter+1) + ")");
        }
        Flusher.setPrefix(acceptPrefix(new PrefixFormatter()));
    }

    @Override
    public void flush(){
        charBuffer='\0';
        charCounter = 0;
    }

    @Override
    public String acceptPrefix(PrefixFormatter prefixFormatter) {
        return prefixFormatter.visitCharMessage(this);
    }
}