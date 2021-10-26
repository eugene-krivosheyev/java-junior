package message;

import accumulator.Accumulator;
import accumulator.StrArrayAccumulator;

public class StrArrayMessage extends Message {

    private String[] body;

    public StrArrayMessage(String[] body) {
        super(new StrArrayAccumulator());
        this.body = body;
    }

    @Override
    public String[] getBody() {
        return body;
    }
}
