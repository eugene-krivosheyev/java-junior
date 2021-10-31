package message;

import accumulator.IntAccumulator;

public class IntMessage extends AbstractMessage
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
