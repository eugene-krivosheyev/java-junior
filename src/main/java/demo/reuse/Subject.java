package demo.reuse;

public class Subject {
    private Strategy strategy;

    public Subject(Strategy strategy) {
        this.strategy = strategy;
    }

    public void log() {
        System.out.println("begin");
        strategy.step();
        System.out.println("end");
    }
}

