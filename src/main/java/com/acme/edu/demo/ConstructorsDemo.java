package com.acme.edu.demo;

public class ConstructorsDemo {
    public static void main(String[] args) {
        final Cat cat = new Cat("", 0);
    }
}

class Cat {
    private String name;
    private int age;

    {
        System.out.println("Hello!");
    }

    Cat(String name, int age) {
//        super(); ^ this();
        System.out.println("1st");
        this.name = name;
        this.age = age;
    }

    Cat(String name) {
        this(name, 0);
        System.out.println("2nd");
    }
}

class Siam extends Cat {
    Siam(String name, int age) {
        super(name, age);
    }

    Siam(String name) {
        super(name);
    }
}
