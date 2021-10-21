package message;

import accumulator.Accumulator;
import accumulator.IntAccumulator;

public class IntMessage implements Message
{
    private final Integer body;

    public IntMessage(Integer integer) {
        body = integer;
    }

    @Override
    public Integer getBody() {
        return body;
    }

    @Override
    public Accumulator getBuffer() {
        return new IntAccumulator();
    }
}
