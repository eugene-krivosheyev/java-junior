package accumulator;

import message.Message;

public class CharAccumulator implements Accumulator {

    private UnpromptLineKeeper unpromtLineKeeper = new UnpromptLineKeeper("char: ");

    @Override
    public String getBody() {
        return null;
    }

    @Override
    public String[] extractUnpromtLines() {
        return unpromtLineKeeper.extract();
    }

    @Override
    public void accumulate(Message character) {
        unpromtLineKeeper.add(character.getBody().toString());
    }
}
