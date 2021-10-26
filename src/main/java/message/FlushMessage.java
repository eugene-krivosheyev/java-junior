package message;

import accumulator.Accumulator;
import accumulator.FlushAccumulator;

public class FlushMessage extends Message {

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
