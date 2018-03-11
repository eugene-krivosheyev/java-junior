package com.acme.edu.message;

import com.acme.edu.Flusher;
import com.acme.edu.MessageController;
import com.acme.edu.formatters.PrefixFormatter;

public class IntMessage implements Message {
    private int message;
    private static int intBuffer;
    private static final String intUsage = "IntMessage";

    public IntMessage(int message) {
        this.message = message;
    }
    @Override
    public String isUsed() {
        return intUsage;
    }

    @Override
    public void accumulate() {
        long sum=intBuffer+(long)message;
        if ((sum)<=Integer.MAX_VALUE && (sum)>=Integer.MIN_VALUE){
            intBuffer +=message;
        }else {
            if ((sum)>Integer.MAX_VALUE){
                sum=sum-Integer.MAX_VALUE;
                Flusher.setUsed(intUsage);
                Flusher.setValue(String.valueOf(Integer.MAX_VALUE));
                Flusher.setPrefix(acceptPrefix(new PrefixFormatter()));
                Flusher.flush();
                intBuffer = (int) sum;
            } else{
                if((sum)<Integer.MIN_VALUE){
                    sum=sum-Integer.MIN_VALUE;
                    Flusher.setUsed(intUsage);
                    Flusher.setValue(String.valueOf(Integer.MIN_VALUE));
                    Flusher.setPrefix(acceptPrefix(new PrefixFormatter()));
                    Flusher.flush();
                    intBuffer = (int) sum;
                }
            }
        }
        Flusher.setUsed(intUsage);
        Flusher.setValue(String.valueOf(intBuffer));
        Flusher.setPrefix(acceptPrefix(new PrefixFormatter()));
    }

    @Override
    public void flush() {
        intBuffer = 0;
    }

    @Override
    public String acceptPrefix(PrefixFormatter prefixFormatter) {
        return prefixFormatter.visitIntMessage(this);
    }
}
