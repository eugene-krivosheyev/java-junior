package com.acme.edu.command;

import com.acme.edu.Type;

public class IntMas4Command implements Command {
    private int[][][][] message;
    private Type CURRENT_TYPE = Type.INT_MAS4;

    public IntMas4Command(int[][][][] message) {
        this.message = message;
    }

    public Type getType() {
        return CURRENT_TYPE;
    }

    public String messageDecorate() {
        String str= "primitives multimatrix: {"+System.lineSeparator();
        for(int[][][] i:message) {
            str=str+"{"+System.lineSeparator();
            for(int[][] j:i) {
                str=str+"{"+System.lineSeparator();
                for(int[] k:j){
                    str=str+"{";
                    for(int m:k){
                        str += m + ", ";
                    }
                    if(k.length>0)
                        str=str.substring(0,str.length()-2)+"}"+System.lineSeparator();
                    else
                        str+="}"+System.lineSeparator();
                }
                str+="}"+System.lineSeparator();
            }
            str+="}"+System.lineSeparator();
        }
        str+="}";
        return str;
    }

    public int[][][][] getIntMasValue() {
        return message;
    }

    @Override
    public boolean accumulate(Command accumulator) {
        return false;
    }
}
