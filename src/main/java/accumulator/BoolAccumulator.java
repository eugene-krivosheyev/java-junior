package accumulator;

import message.Message;

public class BoolAccumulator implements Accumulator {

    private final UnpromptLineKeeper unpromptLineKeeper = new UnpromptLineKeeper("primitive: ");

    @Override
    public String getBody() {
        return null;
    }

    @Override
    public String[] extractUnpromtLines() {
        return unpromptLineKeeper.extract();
    }

    @Override
    public void accumulate(Message bool) {
        unpromptLineKeeper.add(bool.getBody().toString());
    }
}
