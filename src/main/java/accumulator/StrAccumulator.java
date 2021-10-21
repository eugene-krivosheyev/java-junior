package accumulator;

import message.Message;

import java.util.Objects;

public class StrAccumulator implements Accumulator {

    private final String prefix = "string: ";
    protected UnpromptLineKeeper unpromtLineKeeper = new UnpromptLineKeeper(prefix);
    protected int counter = 0;
    protected String body = null;

    public String getBody() {
        String result = (counter > 1) ? body + " (x" + counter + ")" : body;
        return prefix + result;
    }

    @Override
    public String[] extractUnpromtLines() {
        return unpromtLineKeeper.extract();
    }

    @Override
    public void accumulate(Message message) {
        if (!Objects.equals(message.getBody(), body) && body != null) {
            unpromtLineKeeper.add(getBody());
            counter = 0;
        }
        body = (String)message.getBody();
        counter++;
    }
}
