package refactoring.save;

import refactoring.message.Message;

@FunctionalInterface
public interface Saver {
    static void m3() { }
    default void m1() { }
    default void m2() { }
    void save(Message message);
}

class ConSaver implements Saver {
    static void m3() { }

    @Override
    public void save(Message message) {

    }

    @Override
    public void m1() {
        Saver.super.m1();
    }
}