package com.acme.edu;

public class PrimitivesDemo {
    public static void main(String[] args) {
        //region Primitives: 8
        //region Целые
        byte b = 0;
        short s = 0b10;
        int i = 100_000_000;
        long l = 9999999999999999L;

        short counter = 0;
        for (int i1 = 0; i1 <= Short.MAX_VALUE; i1++) {
            counter++;
        }
        System.out.println(counter);
        //endregion
        //region FP
        float f = 0.f; //IEEE 754
        double d = -2E-3; //BigDecimal
        //endregion
        //region Логический
        boolean bb = true | false;
        //endregion
        //region Символьный
        char c = 'ꯉ';
        int ic = c;
        System.out.println(c);
        System.out.println(ic);
        //endregion
        //endregion

        //region Reference type
        String o1 = "abc"; //new String + intern
        String o2 = "abc";
        System.out.println(o1.equals(o2));

        System.out.println(o1);
        String o3 = o1.toUpperCase();
        System.out.println(o3);
        //endregion
    }
}
