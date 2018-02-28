package com.acme.edu.primitives;

public class StackDemo {
    static String ssss = new String("1");

    public static void main(String[] args) {
        System.out.println(new Object()); //JNI / JNA

        String string = new String("abc");
        string = null;
        f2();
        System.gc();
    }

    private static void f2() {
        String s1 = new String("111");
        StackDemo.ssss = null;
    }


}

class GCDemo {

}
