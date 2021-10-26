package message;

import accumulator.Accumulator;

public abstract class Message {
    protected Accumulator accumulator;

    public Message(Accumulator accumulator) {
        this.accumulator = accumulator;
    }

    public abstract Object getBody();
    public Accumulator getAccumulator() {
        return accumulator;
    }
}
