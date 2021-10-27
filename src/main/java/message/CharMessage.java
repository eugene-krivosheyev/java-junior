package message;

import accumulator.CharAccumulator;

public class CharMessage extends AbstractMessage {

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
