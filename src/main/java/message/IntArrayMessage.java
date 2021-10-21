package message;

import accumulator.Accumulator;
import accumulator.IntArrayAccumulator;

public class IntArrayMessage implements Message {

    private Integer[] body;

    public IntArrayMessage(Integer[] body) {
        this.body = body;
    }

    @Override
    public Integer[] getBody() {
        return body;
    }

    @Override
    public Accumulator getBuffer() {
        return new IntArrayAccumulator();
    }
}
