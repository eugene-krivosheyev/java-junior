package com.acme.edu.message;

import com.acme.edu.Flusher;
import com.acme.edu.formatters.PrefixFormatter;

import static java.lang.System.lineSeparator;

public class IntDdlArrayMessage implements Message {
    private int[][] message;
    private static final String intDblArrayUsage = "IntDblArrayMessage";

    public IntDdlArrayMessage(int[][] message) {
        this.message = message;
    }

    @Override
    public String isUsed() {
        return intDblArrayUsage;
    }

    @Override
    public void accumulate() {
        StringBuilder mess = new StringBuilder();
        Flusher.setUsed(intDblArrayUsage);
        for (int i=0; i<message.length; i++){
            mess.append("{");
            for (int j=0; j<message[i].length; j++){
                if (j==(message[i].length-1)){
                    mess.append(message[i][j]+"}"+lineSeparator());
                }else{
                    mess.append(message[i][j]+", ");
                }
            }
        }
        mess.append("}"+lineSeparator());
        Flusher.setValue(mess.toString());
        Flusher.setPrefix(acceptPrefix(new PrefixFormatter()));
    }
    @Override
    public void flush(){
    }

    @Override
    public String acceptPrefix(PrefixFormatter prefixFormatter) {
        return prefixFormatter.visitIntDblArrayMessage(this);
    }
}
