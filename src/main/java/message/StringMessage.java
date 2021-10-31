package message;

import accumulator.StrAccumulator;

public class StringMessage extends AbstractMessage {

    private String body;

    public StringMessage(String body) {
        super(new StrAccumulator());
        this.body = body;
    }

    @Override
    public String getBody() {
        return body;
    }
}
