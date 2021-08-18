package demo;

import java.math.BigDecimal;
import java.math.BigInteger;

public strictfp class PrimitivesDemo {
    public strictfp static void main(String[] args) {
        //region Целочисленные
        byte b1 = 1, b2 = 07, b3 = 0b1; //[-128..127]
        short s = 0xA;
        int i = 1_0_0_0_0_0_0;
        long l = 9999999999999999L;
        //endregion

        //region Дробные
        float f = 0.F; //32bit
        double d = -2E-4; //64bit
        System.out.println(1/3.);
        //endregion

        //region Символьный
        char c = 'c'; //'ꯍ'; // '\uABCD'
        int charCode = c;
        System.out.println(charCode);
        //endregion

        //region логический
        boolean bb = true; //false
        //endregion

        //region Type Overflow
        int i1 = Integer.MAX_VALUE, i2 = 3;
        int result = i1 + i2;
        System.out.println(result);
        System.out.println(Integer.MIN_VALUE);
//        java.math.BigInteger
        //endregion

        //region FP Precision loss (IEEE 754)
        System.out.println(.1 + .2);
//        assertEquals(0.3, .1 + .2, 0.000001)
        BigDecimal bd = new BigDecimal("1.1");
        System.out.println(bd);
        //endregion
    }
}
