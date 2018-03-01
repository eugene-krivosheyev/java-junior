package com.acme.edu.strings;

public class StringsDemo {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";

        Integer i1 = 300; //new Integer(1);
        Integer i2 = 300;

        String s = s1.toUpperCase();
        System.out.println(s);

        String longString = "....";
        String x = longString + i1 + "." + "." + ".";
        StringBuffer sbf = new StringBuffer(longString);
        sbf.append(".") //Fluent interface | Fluent API
            .append(".")
            .append(".");

    }
}
