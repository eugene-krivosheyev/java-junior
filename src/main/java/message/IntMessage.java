package message;

import accumulator.Accumulator;
import accumulator.IntAccumulator;

public class IntMessage extends Message
{
    private final Integer body;

    public IntMessage(Integer body) {
        super(new IntAccumulator());
        this.body = body;
    }

    @Override
    public Integer getBody() {
        return body;
    }
}
