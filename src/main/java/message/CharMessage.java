package message;

import accumulator.Accumulator;
import accumulator.CharAccumulator;

public class CharMessage implements Message {

    private Character body;

    public CharMessage(Character body) {
        this.body = body;
    }

    @Override
    public Character getBody() {
        return body;
    }

    @Override
    public Accumulator getBuffer() {
        return new CharAccumulator();
    }
}
