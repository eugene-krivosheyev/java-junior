package message;

import accumulator.BoolAccumulator;
import accumulator.Accumulator;

public class BooleanMessage implements Message {

    private Boolean body;

    public BooleanMessage(Boolean body) {
        this.body = body;
    }

    @Override
    public Boolean getBody() {
        return body;
    }

    @Override
    public Accumulator getBuffer() {
        return new BoolAccumulator();
    }
}
