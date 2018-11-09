package demo;

public class PrimitivesDemo {
    public strictfp static void main(String[] args) {
        //region целочисленные
        byte b = 0x0; //0..255 | -127..128
        short s = 10_000; //Short.MAX_VALUE
        int i = 0;
        long l = 999_999_999_999_999L;
        //endregion

        //region рациональные
        float f = 1.F;
        double d = -2e-5;
        //endregion

        //region логический
        boolean bb = true | false;
        //endregion

        //region символ
        char c = '\b'; //Character.CURRENCY_SYMBOL
        int charCode = c;
//        System.out.println(c);
//        System.out.println(charCode);
        //endregion

        //region Type Overflow Problem
        byte counter = 0;
        for (int ii = 0; ii < 130; ii++) {
            counter++;
        }
        System.out.println(counter);
        //endregion

        //region (Float|Double) Precision Loss
        int var = 10_000;
        System.out.println( (byte)var );

        //IEEE 754 -> BigDecimal -> Apache Jakarta Commons Math
        System.out.println(1./3);
        System.out.println(.1 + .2);
        //endregion

        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
    }
}
