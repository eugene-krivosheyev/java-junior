package com.acme.edu.message;

import com.acme.edu.Flusher;
import com.acme.edu.formatters.PrefixFormatter;

import static java.lang.System.lineSeparator;

public class IntArrayMessage implements Message{

    private int[] message;
    private static final String intArrayUsage = "IntArrayMessage";

    @Override
    public String isUsed() {
        return intArrayUsage;
    }
    public IntArrayMessage(int... message) {
        this.message = message;
    }
    @Override
    public void accumulate() {
        StringBuilder mess = new StringBuilder();
        int sum=0;
        Flusher.setUsed(intArrayUsage);
        for(int i=0; i<message.length; i++){
            if(i==(message.length-1)){
                mess.append(message[i]+"}");
                sum+=message[i];
            } else {
                mess.append(message[i]+", ");
                sum+=message[i];
            }
        }
        mess.append(lineSeparator()+sum);
        Flusher.setValue(mess.toString());
        Flusher.setPrefix(acceptPrefix(new PrefixFormatter()));
    }
    @Override
    public void flush(){
    }

    @Override
    public String acceptPrefix(PrefixFormatter prefixFormatter) {
        return prefixFormatter.visitIntArrayMessage(this);
    }
}
