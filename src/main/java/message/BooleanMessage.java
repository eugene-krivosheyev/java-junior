package message;

import accumulator.BoolAccumulator;

public class BooleanMessage extends AbstractMessage {

    private Boolean body;

    public BooleanMessage(Boolean body) {
        super(new BoolAccumulator());
        this.body = body;
    }

    @Override
    public Boolean getBody() {
        return body;
    }
}
