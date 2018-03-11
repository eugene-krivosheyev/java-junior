package com.acme.edu.message;


import com.acme.edu.Flusher;
import com.acme.edu.formatters.PrefixFormatter;

import static java.lang.System.lineSeparator;

public class StringArrayMessage implements Message {
    private String[] message;
    private static final String stringArrayUsage = "StringArrayMessage";

    public StringArrayMessage(String... message) {
        this.message = message;
    }

    @Override
    public String isUsed() {
        return stringArrayUsage;
    }

    @Override
    public void accumulate() {
        StringBuilder messb = new StringBuilder();
        Flusher.setUsed(stringArrayUsage);
        for (String mess:message) {
            messb.append(mess+lineSeparator());
        }
        Flusher.setValue(messb.toString());
        Flusher.setPrefix(acceptPrefix(new PrefixFormatter()));
    }
    @Override
    public void flush(){
    }

    @Override
    public String acceptPrefix(PrefixFormatter prefixFormatter) {
        return prefixFormatter.visitStringArrayMessage(this);
    }
}
