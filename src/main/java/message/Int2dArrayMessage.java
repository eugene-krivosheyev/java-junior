package message;

import accumulator.Accumulator;
import accumulator.Int2DArrayAccumulator;

public class Int2dArrayMessage implements Message {

    private Integer[][] body;

    public Int2dArrayMessage(Integer[][] body) {
        this.body = body;
    }

    @Override
    public Integer[][] getBody() {
        return body;
    }

    @Override
    public Accumulator getBuffer() {
        return new Int2DArrayAccumulator();
    }
}
