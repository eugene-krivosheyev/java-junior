package buffer;

import message.Message;

import java.util.ArrayList;
import java.util.Objects;

public class StrBuffer implements Buffer {

    private final String prefix = "string: ";
    protected OutOfOrderLineKeeper lineKeeper = new OutOfOrderLineKeeper(prefix);
    protected int counter = 0;
    protected String body = null;

    public String getBody() {
        String result = (counter > 1) ? body + " (x" + counter + ")" : body;
        return prefix + result;
    }

    @Override
    public ArrayList<String> getExtraordinaryBody() {
        return lineKeeper.getExtraordinaryBody();
    }

    @Override
    public void accumulate(Message message) {
        if (!Objects.equals(message.getBody(), body) && body != null) {
            lineKeeper.add(getBody());
            counter = 0;
        }
        body = (String)message.getBody();
        counter++;
    }
}
