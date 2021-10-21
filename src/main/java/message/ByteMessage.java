package message;

import accumulator.Accumulator;
import accumulator.ByteAccumulator;

public class ByteMessage implements Message {

    private Byte body;

    public ByteMessage(Byte body) {
        this.body = body;
    }

    @Override
    public Byte getBody() {
        return body;
    }

    @Override
    public Accumulator getBuffer() {
        return new ByteAccumulator();
    }
}
