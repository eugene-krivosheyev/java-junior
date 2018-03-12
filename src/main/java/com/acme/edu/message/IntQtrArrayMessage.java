package com.acme.edu.message;

import com.acme.edu.Flusher;
import com.acme.edu.formatters.PrefixFormatter;

import static java.lang.System.lineSeparator;

public class IntQtrArrayMessage implements Message{
    private int[][][][] message;
    private static final String intQtrArrayUsage = "IntQtrArrayMessage";

    public IntQtrArrayMessage(int[][][][] message) {
        this.message = message;
    }

    @Override
    public String isUsed() {
        return intQtrArrayUsage;
    }

    @Override
    public void accumulate() {
        StringBuilder mess = new StringBuilder();
        Flusher.setUsed(intQtrArrayUsage);
        for (int i=0; i<message.length; i++) {
            mess.append("{"+lineSeparator());
            for (int j = 0; j < message[i].length; j++) {
                mess.append("{"+lineSeparator());
                for (int k = 0; k < message[i][j].length; k++) {
                    mess.append("{"+lineSeparator());
                    for (int l = 0; l < message[i][j][k].length; l++) {
                        if (l == (message[i][j][k].length - 1)) {
                            mess.append(message[i][j][k][l] + lineSeparator() + "}" +lineSeparator());
                        } else {
                            mess.append(message[i][j][k][l] + ", ");
                        }
                    }
                    mess.append("}"+lineSeparator());
                }
                mess.append("}"+lineSeparator());
            }
            mess.append("}"+lineSeparator());
        }
        Flusher.setValue(mess.toString());
        Flusher.setPrefix(acceptPrefix(new PrefixFormatter()));
    }
    @Override
    public void flush(){
    }

    @Override
    public String acceptPrefix(PrefixFormatter prefixFormatter) {
        return prefixFormatter.visitIntQtrArrayMessage(this);
    }
}
