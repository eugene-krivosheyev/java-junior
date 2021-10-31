package message;

import accumulator.IntArrayAccumulator;

public class IntArrayMessage extends AbstractMessage {

    private Integer[] body;

    public IntArrayMessage(Integer[] body) {
        super(new IntArrayAccumulator());
        this.body = body;
    }

    @Override
    public Integer[] getBody() {
        return body;
    }
}
