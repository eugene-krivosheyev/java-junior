package message;

import accumulator.Accumulator;
import accumulator.StrAccumulator;

public class StringMessage implements Message {

    private String body;

    public StringMessage(String body) {
        this.body = body;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public Accumulator getBuffer() {
        return new StrAccumulator();
    }
}
