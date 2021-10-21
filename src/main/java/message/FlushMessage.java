package message;

import accumulator.FlushAccumulator;

public class FlushMessage implements Message {

    @Override
    public Object getBody() {
        return null;
    }

    @Override
    public FlushAccumulator getBuffer() {
        return new FlushAccumulator();
    }
}
