package com.acme.edu.demo;

public class StringDemo {
    public static void main(String[] args) {
        String string1 = "abc"; //new String(???)
        String string2 = "abc"; //new String() -> = string1

        String s = string1.toUpperCase();
        System.out.println(s);

        Integer i1 = -129; //new Integer(??) + intern()
        Integer i2 = -129;
        System.out.println( i1 == i2 ); //FIXME NEVER!!!!
    }
}
