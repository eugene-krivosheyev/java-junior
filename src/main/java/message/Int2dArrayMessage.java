package message;

import accumulator.Accumulator;
import accumulator.Int2DArrayAccumulator;

public class Int2dArrayMessage extends Message {

    private Integer[][] body;

    public Int2dArrayMessage(Integer[][] body) {
        super(new Int2DArrayAccumulator());
        this.body = body;
    }

    @Override
    public Integer[][] getBody() {
        return body;
    }
}
