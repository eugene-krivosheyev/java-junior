package accumulator;

import message.Message;

public class ObjectAccumulator implements Accumulator {

    private UnpromptLineKeeper unpromtLineKeeper = new UnpromptLineKeeper("reference: ");

    @Override
    public String getBody() {
        return null;
    }

    @Override
    public String[] extractUnpromtLines() {
        return unpromtLineKeeper.extract();
    }

    @Override
    public void accumulate(Message object) {
        unpromtLineKeeper.add(object.getBody().toString());
    }

}
