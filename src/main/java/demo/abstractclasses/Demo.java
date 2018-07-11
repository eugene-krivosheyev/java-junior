package demo.abstractclasses;

public class Demo {
    public static void main(String[] args) {
        //Creator Pattern
        Animal animal = new Cat(); //IS-A: extends || implements
        // 1Msloc: based on animal
        animal.sound();

        if (animal instanceof Cat) {
            ((Cat)animal).mimimi();
        } else {

        }

//        Cat cat = new Animal();
        System.out.println(animal.getCount()); //
    }
}

  class Animal {
    /**
     * Default behavior || abstract
     */
    public  void sound() {}
    public static long getCount() {
        return 4;
    }
}

/**
 * 1. Polymorphism
 * 2. Code Reuse with Overriding
 */
class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("MEOW!!!!");
    }

    public void mimimi() {

    }

    public static long getCount() {
        return 5;
    }
}

class Alian extends Animal {
    @Override
    public void sound() {
        System.out.println("BRKSJFDKFGJDFGDFNG!!");
    }

    public void killWithExternalJaw() {

    }
}
