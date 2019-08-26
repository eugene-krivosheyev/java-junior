package com.acme.edu.demo;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Object[] objects = new Object[] {
                1,
                "str1",
                new Integer(1)
        };

        for (Object current : objects) {
            current.toString();
        }

        Animal someWho = new Duck(0);
        if (someWho instanceof Duck) {
            final Duck someDuck = (Duck) someWho;
            someDuck.swim();
        }

    }
}

class Dog extends Animal {
    public Dog(int age) {
        super(age);
    }

    @Override
    public void sound() {

    }
}

class Duck extends Animal {
    public Duck(int age) {
        super(age);
    }

    @Override
    public void sound() {
        getAge();
    }

    public void swim() {
        //....
    }
}

abstract class Animal implements Aoeucariot {
    //region For Reuse
    private int age;

    public Animal(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    //endregion

    //region For Polymorphism
    public abstract void sound();
    //endregion

    @Override
    public Aoeucariot split() {
        return null;
    }
}

interface Aoeucariot {
    public static final int i = 0;
    Aoeucariot split();

    //region Defender methods
    static void breath() {

    }

    default void doSomeWeirdStaff() {
        this.split();
    }
    //endregion
}
