package demo.tm;

import java.util.Set;

import static demo.tm.Strategy.lookMaIUseImplementationInInterface;

public interface Strategy {
    public static final int MY_CONST = 0;
    public abstract void step();

    public static void lookMaIUseImplementationInInterface() {
        System.out.println("ку-ку");
    }

    public default void instanceMethod() {
        this.step();
    }
}

class StrategyImpl implements Strategy {
    @Override
    public void step() {

    }

    @Override
    public void instanceMethod() {
        Strategy.super.instanceMethod();
    }
}

class Demo {
    public static void main(String[] args) {
        lookMaIUseImplementationInInterface();

        Set.of(1,2);
    }
}