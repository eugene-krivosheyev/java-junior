package com.acme.edu.demo;

public class Primitives {
    public strictfp static void main(String[] args) {
        //region Primitives
        //region Целые
        byte b = 0b1;
        short s = 0;
        int i = 10_000_000;
        long l = 9999999999999L;
        //endregion
        //region Вещесв
        float f = 0.F; //IEEE 754
        double d = 1e5;
        //endregion
        //region Boolean
        boolean boo = true | false;
        //endregion
        //region Char
        char c = '\0';
        int charCode = c;
        //endregion
        //endregion
    }
}
