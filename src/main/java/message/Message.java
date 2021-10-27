package message;

import accumulator.Accumulator;
import exeption.EmptyAccumulatorException;

public abstract class Message {
    protected Accumulator accumulator;

    public Message(Accumulator accumulator) {
        this.accumulator = accumulator;
    }

    public abstract Object getBody();
    public Accumulator getAccumulator() throws EmptyAccumulatorException {
        if (accumulator == null) throw new EmptyAccumulatorException("Accumulator is empty");
        return accumulator;
    }
}

