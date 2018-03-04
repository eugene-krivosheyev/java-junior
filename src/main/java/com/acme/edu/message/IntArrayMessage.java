package com.acme.edu.message;

public class IntArrayMessage implements Message{

    private int[] message;
    private static boolean intArrayUsage;

    public static boolean isIntArrayUsage() {
        return intArrayUsage;
    }
    public IntArrayMessage(int... message) {
        this.message = message;
    }
    @Override
    public void accumulate() {
        intArrayUsage = true;
        System.out.print("primitives array: {");
        for(int i=0; i<message.length; i++){
            if(i==(message.length-1)){
                System.out.println(message[i]+"}");
            } else {
                System.out.print(message[i]+", ");
            }
        }
    }
    public static void flush(){
        intArrayUsage = false;
    }
}
