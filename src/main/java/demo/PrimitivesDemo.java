package demo;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class PrimitivesDemo {
    public static strictfp void main(String[] args) {
        //region Целые
        byte b = 07; //0b100
        short s = 1_000;
        int i = 0xDEADCAFE;
        long l = 999999999999999999L;
        //Byte.MAX_VALUE
        //endregion

        //region Дробные
        float f = .0F; //32 bit
        double d = 2.1e3; //64 bit
        //Float.MAX_VALUE
        //endregion

        //region Логический
        boolean bb = true; //false
        //bb = (boolean) 5;
        //endregion

        //region Символьный
        char c = 'ざ'; //int charCode = c;
        System.out.println( (char)0xABCD );
        System.out.println('\n');
        //endregion


        //region Приведение типов
        //region Arithmetic promotions
        byte b1 = 1, b2 = 2;
        int byteResult = b1 + b2;
        long intLongResult = 1 + 1L;
        //endregion
        //region Auto casting, неявное приведение
        short shortResult = b1;
        //endregion
        //region Явное приведение
        int smallIntValue = Byte.MAX_VALUE + 1;
        byte smallByteValue = (byte) smallIntValue;
        System.out.println(smallByteValue);
        //endregion
        //endregion

        //region Troubles!!!!
        //region Silent Type Overflow для целых
        byte accumulator = Byte.MIN_VALUE;
        for (int counter = 0; counter <= 257; counter++) {
            accumulator++;
        }
        System.out.println(accumulator);
        // -> BigInteger
        //endregion

        //region Precision Loss для fp
        System.out.println( .1 + .2 ); //IEEE 754
        // -> BigDecimal
        //endregion
        //endregion

        //region Reference types
        Object object = new Object();
        Object object2 = object;
        System.out.println( object == object2 );
        subMethod(object2);
        //endregion

        //region String
        String str1 = "abc"; //new String("abc") -> string pool
        String str2 = "abc"; //str2 = str1
        System.out.println( str1 == str2 );

        final String newStr = str1.toUpperCase();
        System.out.println(str1);

        String s1 = new String("abc");
        String s2 = new String("abc");
        //String.intern
        System.out.println( s1 == s2 );
        //endregion

        String strResult = "a" + "b" + "c";
        // -> StringBuffer/StringBuilder
    }

    private static void subMethod(Object toPrint) {
        System.out.println(toPrint);
    }
}

class Employee {
    private static String companyName = "";

    //-.-.-.-.-.-.-.-.-.-.-

    private int id;
    private Employee boss;
}