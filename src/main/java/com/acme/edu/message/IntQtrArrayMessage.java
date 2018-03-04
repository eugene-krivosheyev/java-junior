package com.acme.edu.message;

public class IntQtrArrayMessage implements Message{
    private int[][][][] message;
    private static boolean intQtrArrayUsage;

    public IntQtrArrayMessage(int[][][][] message) {
        this.message = message;
    }

    public static boolean isIntQtrArrayUsage() {
        return intQtrArrayUsage;
    }

    @Override
    public void accumulate() {
        intQtrArrayUsage = true;
        System.out.println("primitives multimatrix: {");
        for (int i=0; i<message.length; i++) {
            System.out.println("{");
            for (int j = 0; j < message[i].length; j++) {
                System.out.println("{");
                for (int k = 0; k < message[i][j].length; k++) {
                    System.out.println("{");
                    for (int l = 0; l < message[i][j][k].length; l++) {
                        if (l == (message[i][j][k].length - 1)) {
                            System.out.println(message[i][j][k][l]);
                            System.out.println("}");
                        } else {
                            System.out.println(message[i][j][k][l] + ", ");
                        }
                    }
                    System.out.println("}");
                }
                System.out.println("}");
            }
            System.out.println("}");
        }
    }
    public static void flush(){
        intQtrArrayUsage = false;
    }
}
