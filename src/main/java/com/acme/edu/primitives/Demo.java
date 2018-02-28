package com.acme.edu.primitives;

public class Demo {
    public strictfp static void main(String[] args) {
        //region Целочисленные
        byte b = 01; //0..255 | -12x ... +12x
        short s = -10; //
        int i = 1_000_000;
        long l = 9_999_999_999_999_999L;
//        System.out.println(Byte.MIN_VALUE + .0);
        //endregion

        //region С плавающей точкой
        float f = 0.0F;
        double d = -2e-3D; //-2 * 10 ^ -3
        //endregion

        //region Символы
        char c = '\b';//'\u999F';//123;
//        System.out.println(c);
        //endregion

        //region Логический
        boolean bb = true | false;
        //endregion

        //region Overflow | FP Precision Loss
        byte counter = Byte.MIN_VALUE;
        for (int ii = 0; ii <= 257; ii++) {
            counter++;
        }
        System.out.println(counter);

        System.out.println(.1 + .2); //IEEE 705
        //endregion

        //region Casting
        int iii = 400;
        byte bbb = (byte)iii;
        System.out.println(bbb);

        iii = bbb;
        System.out.println(1/3.);
        //endregion


        //region Operators
        //Arithme:
        System.out.println(0/0.); //+ - * / %
        System.out.println("rrr" + 5 + "fggg"); //+ - * / %
        System.out.println(1 + 2 + "3" + 4 / 5);

        System.out.println(1 & 2 | 3 ^ ~4);
        System.out.println(10 >>> 33);

        System.out.println(f1() && !f2());
        //fopen('ffff') or die();

        System.out.println((f1() ? f2() ? f3() : 3 : 2));

        byte incr = 0b111;
        System.out.println(incr--);
        byte bbbbb = incr++;
        byte bbbbbb = (byte)(incr + 1); //arith. promotion

        incr /= 2; //incr = incr + 2;

        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1 ^ b2); //XOR logical
        //endregion
    }

    private static String f3() {
        return null;
    }

    /**
     * Side effect!!!!!111
     */
    private static boolean f2() {
        return true;
    }

    private static boolean f1() {
        return true;
    }
}
