package com.acme.edu.message;

import com.acme.edu.Flusher;

public class IntDdlArrayMessage implements Message {
    private int[][] message;
    private static boolean intDblArrayUsage;

    public IntDdlArrayMessage(int[][] message) {
        this.message = message;
    }

    @Override
    public boolean isUsed() {
        return intDblArrayUsage;
    }

    @Override
    public void accumulate() {
        intDblArrayUsage = true;
        System.out.println("primitives matrix: {");
        for (int i=0; i<message.length; i++){
            System.out.print("{");
            for (int j=0; j<message[i].length; j++){
                if (j==(message[i].length-1)){
                    System.out.print(message[i][j]);
                    System.out.println("}");
                }else{
                    System.out.print(message[i][j]+", ");
                }
            }
        }
        System.out.println("}");
        //Flusher.setBuffer(intBuffer);
        Flusher.setUsage(intDblArrayUsage);
    }
    @Override
    public void flush(){
        intDblArrayUsage = false;
    }
}
