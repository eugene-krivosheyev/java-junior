package message;

import accumulator.FlushAccumulator;

public class FlushMessage extends AbstractMessage {

    public FlushMessage() {
        super(null);
    }

    @Override
    public Object getBody() {
        return null;
    }

    @Override
    public FlushAccumulator getAccumulator() {
        return new FlushAccumulator();
    }
}
