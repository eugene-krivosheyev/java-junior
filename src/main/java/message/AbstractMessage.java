package message;

import accumulator.Accumulator;

public abstract class AbstractMessage implements Message {
    protected Accumulator accumulator;

    public AbstractMessage(Accumulator accumulator) {
        this.accumulator = accumulator;
    }

    @Override
    public Accumulator getAccumulator() {
        return accumulator;
    }
}

