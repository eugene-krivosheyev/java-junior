package message;

import accumulator.Accumulator;
import accumulator.ByteAccumulator;

public class ByteMessage extends Message {

    private Byte body;

    public ByteMessage(Byte body) {
        super(new ByteAccumulator());
        this.body = body;
    }

    @Override
    public Byte getBody() {
        return body;
    }
}
