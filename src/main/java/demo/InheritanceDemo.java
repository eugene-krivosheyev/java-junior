package demo;

import java.sql.Connection;
import java.util.Arrays;

public class InheritanceDemo {
    public static void main(String[] args) {
        T object = new T(new T1());
        object.m();

        State.staticDefenderM();
        new T1().instanceDefenderM();

        m(new T1());
        m(new T2());

        State[] array = { new T1(), new T2() };
        for (State current : array) {
            current.step();
        }
    }

    private static void m(State state) {
        state.step();
    }
}

/**
 * Template Method <-> Strategy/State
 */
class T {
    private State state;

    T(State state) {
        this.state = state;
    }

    public void m() {
        System.out.println("step 1"); // 1
        state.step(); // 2
        System.out.println("step 3"); // 3
    }
}

interface State {
    int MY_CONST = 0;
    void step();

    public static void staticDefenderM() {

    }

    public default void instanceDefenderM() {
        this.step();
    }
}

class T1 implements State {
    @Override
    public void step() {
        System.out.println("step 2 variant 1");
    }
}

class T2 implements State {
    @Override
    public void step() {
        System.out.println("step 2 var 2");
    }
}

class Santehnik {
    public void fix() {
        this.sayHello();
        //.....
        //.....
    }

    protected void sayHello() {
        System.out.println("Hi");
    }
}

// Special Case
class NotSoTrezv extends Santehnik {
    @Override
    public void sayHello() {
        System.out.println("!!!!!!!!$%^$&^*&^*&^*");
    }
}







