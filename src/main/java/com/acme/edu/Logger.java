package com.acme.edu;

import java.util.Objects;

public class Logger {
    public strictfp static void main(String... args) {
        //region целочисленные
        byte b = 0b0; //literal
        short s = 01_000;
        int i = 0X10;
        long l = 1_000_000_000_000L;
        //endregion

        //region с плавающей точкой
        float f = 0.1F; //IEEE 754
        double d = -2.2e-3;
        //endregion

        //region символьный
        char c = '\uAAAA';
        //endregion

        //region логический
        boolean bb = true | false;
        //endregion

        //region Castings
        int ii = 1_000;
        byte bbb = (byte)ii;
//        System.out.println(bbb);
        //endregion

        //region Overflow
        byte value = -128;
        for (int counter = 0; counter < 257; counter++) {
            value++;
        }
//        System.out.println(value);
        //endregion

        //region Precision loss
        System.out.println(.1 + .2);
        //endregion

        //region Strings
        String str1 = "test" + " string"; //pool check + new
        String str2 = "test string"; //string pool
        System.out.println(str1 == str2); //interning

        String aaaa = new String("a");
        String bbbb = "a";
        System.out.println(aaaa.equals(bbbb));

        bbbb.toUpperCase();
        System.out.println(bbbb);
        //endregion

        //region Equality issues
        str1.equals("a"); //NPE!!!!
        "a".equals(str1);
        Objects.equals(str1, "a");
        //endregion

        //region String Extensions
        StringBuilder sbl;
        StringBuffer sbf;

        //"a" + "b" + "c" + "d" ->
        new StringBuilder("a") //Fluent API | interface
                .append("b")
                .append("c")
                .append("d"); //Oracle JVM optimization
        //endregion
    }
}
