package interfacesandabstractclasses;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Objects;

public class InterfacesAndAbstractClasses {
    public static void main(String[] args) {
        System.out.println(Flyable.STRATOSPHERE);

        Hawk hawk = new Hawk();
        System.out.println(hawk instanceof Object);
        System.out.println(hawk instanceof Flyable);
        System.out.println(hawk instanceof Cloneable);
    }
}

/**
 * Inheritance:
 * 1. Reuse: state & behavior
 * 2. IS-A: polymorphism
 * 3. ONE superclass
 */
abstract class Animal {
    public void run() {
        //...
        this.sound();
        //...
    }

    public abstract void sound();
}

/**
 * Trait
 */
interface Flyable {
    public static final int STRATOSPHERE = 10_000;
    public Object fly();
}

//@Serializable(state=1, target="io")
class Hawk extends Animal implements Flyable, Humanable {
    @Override
    public void sound() {

    }

    @Override
    public String fly() {
        return null;
    }
}

interface Humanable {
    public String fly();
}
