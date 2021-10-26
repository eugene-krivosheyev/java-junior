package message;

import accumulator.Accumulator;
import accumulator.StrAccumulator;

public class StringMessage extends Message {

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
