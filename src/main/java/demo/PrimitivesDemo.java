package demo;

import java.math.BigDecimal;
import java.math.BigInteger;

public strictfp class PrimitivesDemo {
    int iii;
    static int iiii;
    static Integer iiiiiii = new Integer(0);

    public static strictfp void main(String[] args) {
        //region целочисленные
        byte b = 0b10;
        short s = 0;
        int i = 10_000_000;
        long l = 9999999999999999L;
        //endregion

        //region дроби
        float f = 0.F;
        double d = -2e-7;
        //endregion

        //region символьный
        char c = '\uABCD';
        //endregion

        //region логический
        boolean bb = true; // false
        //endregion

        //region Инициализация локальных переменных!!!!111
        int ii = 0;
        System.out.println(ii);
        //endregion

        //region Type inference
        var variable = 0;
        var var1 = 'c';
        //endregion

        //region Type Overflow
        byte counter = Byte.MAX_VALUE;
        counter++;
        counter++;
        counter++;
        System.out.println(counter); //???????

        BigInteger bi;
        //endregion

        //region FP precision loss
        System.out.println( .02 - .03 );
        System.out.println( .1 + .2 ); // IEEE 754
        System.out.println( .1 + .3 );

        BigDecimal bd;
        //endregion

        //region Reference Types
        Object iiiii = new Object(); //32 bit
        System.out.println(iiiii.toString());
        //endregion

        //region Wrappers
        Byte byteRef = 1;
        byte primitiveByte = byteRef;

        while (true) {
            byteRef++;
//            byte b1 = byteRef.byteValue();
//            b1++;
//            Byte.valueOf(b1);
        }
        //endregion


    }
}
