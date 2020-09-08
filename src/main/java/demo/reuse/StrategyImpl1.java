package demo.reuse;

import java.io.Serializable;

public abstract class StrategyImpl1 implements Strategy, Serializable {
    @Override
    public void step() {
        System.out.println("custom string 1");
    }
}
