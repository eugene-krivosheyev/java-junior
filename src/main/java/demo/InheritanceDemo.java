package demo;

public class InheritanceDemo {
    public static void main(String[] args) {
        T object = new T2();
        object.m();
    }
}

/**
 * Template Method
 */
abstract class T {
    public void m() {
        System.out.println("step 1"); // 1
        this.step(); // 2
        System.out.println("step 3"); // 3
    }

    protected abstract void step();
}

class T1 extends T {
    @Override
    protected void step() {
        System.out.println("step 2 variant 1");
    }
}

class T2 extends T {
    @Override
    protected void step() {
        System.out.println("step 2 var 2");
    }
}