package message;

import accumulator.Accumulator;
import accumulator.CharAccumulator;

public class CharMessage extends Message {

    private Character body;

    public CharMessage(Character body) {
        super(new CharAccumulator());
        this.body = body;
    }

    @Override
    public Character getBody() {
        return body;
    }
}
