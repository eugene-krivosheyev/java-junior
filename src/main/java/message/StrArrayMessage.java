package message;

import accumulator.Accumulator;
import accumulator.StrArrayAccumulator;

public class StrArrayMessage implements Message {

    private String[] body;

    public StrArrayMessage(String[] body) {
        this.body = body;
    }

    @Override
    public String[] getBody() {
        return body;
    }

    @Override
    public Accumulator getBuffer() {
        return new StrArrayAccumulator();
    }
}
