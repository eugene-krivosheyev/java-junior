package com.acme.edu.ooad;

public class OoadDemo {
    private final int ii; //blank final
    public static final int MY_SUPER_CONST = 0;

    public OoadDemo(int i) {
        ii = 0;
    }

    public static void main(final String[] args) {
        new Girl(0);
    }
}

class Woman {
    private int age;

    public Woman(int i) {
        System.out.println("1");
        this.age = age;
    }
}

class Girl extends Woman {
    {
        System.out.println("!!!");
    }

    {
        System.out.println("!!!!!!");
    }

    public Girl(int i) {
        super(i);
    }
}

