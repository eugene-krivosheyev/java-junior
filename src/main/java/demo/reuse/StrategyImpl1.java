package demo.reuse;

public class StrategyImpl1 implements Strategy {
    @Override
    public void step() {
        System.out.println("custom string 1");
    }
}
