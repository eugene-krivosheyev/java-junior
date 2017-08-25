package com.acme.edu;

import java.util.Objects;

public class Logger {
    private static boolean isPreviousInt = false;
    private static long intSum = 0;

    private static boolean isPreviousByte = false;
    private static int byteSum = 0;

    private static String previousString = null;
    private static int equalStringsCount = 0;

    public static void log(Object message) {
        if (isNull(message)) {
            return;
        }

        cachePrint();
        System.out.println("reference: " + message);
    }

    public static void log(int[] message) {
        if (isNull(message)) {
            return;
        }

        cachePrint();
        System.out.println("primitives array: " + arrayToString(message));
    }

    public static void log(int message) {
        if (!isPreviousInt) {
            cachePrint();
            isPreviousInt = true;
        }

        if (intSum + message > (long) Integer.MAX_VALUE) {
            System.out.println("primitive: " + Integer.MAX_VALUE);
            intSum = (message + intSum) % Integer.MAX_VALUE;
        } else if (intSum + message < (long) Integer.MIN_VALUE) {
            System.out.println("primitive: " + Integer.MIN_VALUE);
            intSum = (message + intSum) % Integer.MIN_VALUE;
        } else {
            intSum += message;
        }
    }

    public static void log(boolean message) {
        cachePrint();
        System.out.println("primitive: " + message);
    }

    public static void log(String message) {
        if (isNull(message)) {
            return;
        }

        if ("".equals(message)) {
            return;
        }

        if (previousString == null || !previousString.equals(message)) {
            cachePrint();
            previousString = message;
            equalStringsCount = 1;
        } else {
            equalStringsCount++;
        }
    }

    public static void log(char message) {
        cachePrint();
        System.out.println("char: " + message);
    }

    public static void log(byte message) {
        if (!isPreviousByte) {
            cachePrint();
        }

        isPreviousByte = true;
        if (byteSum + message > (int) Byte.MAX_VALUE) {
            System.out.println("primitive: " + Byte.MAX_VALUE);
            byteSum = (message + byteSum) % Byte.MAX_VALUE;
        } else if (byteSum + message < (int) Byte.MIN_VALUE) {
            System.out.println("primitive: " + Byte.MIN_VALUE);
            byteSum = (message + byteSum) % Byte.MIN_VALUE;
        } else {
            byteSum += message;
        }
    }

    public static void cachePrint() {
        if (isPreviousInt) {
            System.out.println("primitive: " + intSum);
            intSum = 0;
            isPreviousInt = false;
        }

        if (isPreviousByte) {
            System.out.println("primitive: " + byteSum);
            byteSum = 0;
            isPreviousByte = false;
        }

        if (previousString != null) {
            String appendix = (equalStringsCount > 1) ? " (x" + equalStringsCount + ")" : "";
            System.out.println("string: " + previousString + appendix);
            equalStringsCount = 0;
            previousString = null;
        }
    }

    private static boolean isNull(Object message) {
        return message == null;
    }

    private static String arrayToString(int[] a) {
        int iMax = a.length - 1;
        if (iMax == -1)
            return "{}";

        StringBuilder b = new StringBuilder();
        b.append('{');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append('}').toString();
            b.append(", ");
        }
    }

    public static void main(String[] args) {

        Logger.log(-5);
        Logger.log(Integer.MIN_VALUE);
        Logger.log(-8);
        Logger.cachePrint();

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
        byte bbb = (byte) ii;
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

        //"a" + "b" + "c" + "d" -> //Oracle JVM optimization
        new StringBuilder("a") //Fluent API | interface
                .append("b")
                .append("c")
                .append("d");
        //endregion

        //region Extract explaining variable
        Object message = null;
        boolean isBoolean = message instanceof Boolean;
        boolean isByte = message instanceof Byte;

        if (message instanceof Integer || isBoolean || isByte) {

        }
        //endregion

        //region operators
        //region promotions
        //byte, short, int -> int; long -> long; float, double -> f/d.
        //endregion
        //region bitwise
        System.out.println(4 >>> 33); // &, |,  ~, ^
        //endregion
        //region logical
        System.out.println(f1() && f2()); //& | !
        //fopen("file") or die();
        //endregion
        //region compare
        System.out.println((2 != 3) && (1 == 1)); // > < != <= >= instanceof
        //endregion
        //region ternary
        System.out.println( 1!=1 ? 0 : f() );
        //endregion

        //region controlling executions
        if (true) {
            //....
        } else if(false) {

        } else {

        }

        String sss = null;
        final String sss2 = "5";
        switch (sss) {
            case sss2:
                System.out.println("1");
            case "4":
                System.out.println("5");
                break;
            case "3":
                System.out.println("3");
                break;
            default:
                System.out.println("def!!!!");
                break;
        }

        Color var = null;
        switch (var) {

        }
        //endregion

        //region Cycles
        for (int j = 0; j < 10; j++) {

        }

        outer: do {
            inner: while (1 == theOne()) {
                break outer;
//                continue inner;
            }
        } while (false);

        for (String current : args) {

        }

        System.out.println("");
        //endregion
    }

    private static int theOne() {
        return 1;
    }

    private static boolean f() {
        System.out.println("!!!!!!!");
        return false;
    }

    private static boolean f2() {
        return true;
    }

    private static boolean f1() {
        return true;
    }

}

enum Color {
    RED, GREEN, BLUE
}
