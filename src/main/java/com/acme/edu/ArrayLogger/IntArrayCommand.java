package com.acme.edu.ArrayLogger;


public class IntArrayCommand implements ArrayCommand{
    private final static String PREFIX_PRIMITIVES_ARRAY = "primitives array: ";


    private int[] array;

    public IntArrayCommand(int[] array) {
        this.array = array;
    }

    @Override
    public String decorate() {
        return PREFIX_PRIMITIVES_ARRAY + intArrayToString();
    }


    private String intArrayToString() {
        String res = "{";
        for(int i = 0; i < array.length; ++i) {
            res += Integer.toString(array[i]);
            if (i < array.length - 1) {
                res += ", ";
            }
        }
        return res + "}";
    }

}
