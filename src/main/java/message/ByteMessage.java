package message;

import accumulator.ByteAccumulator;

public class ByteMessage extends AbstractMessage {

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
