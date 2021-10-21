package buffer;

import message.Message;

import java.util.Objects;

public class StrBuffer extends Buffer {

    protected int counter = 0;
    protected String body = null;

    public StrBuffer() {
        prefix = "string: ";
    }

    public String getBody() {
        String result = (counter > 1) ? body + " (x" + counter + ")" : body;
        return prefix +result;
    }

    public void accumulate(Message message) {
        if (!Objects.equals(message.getBody(), body) && body != null) {
            extraOrdinary.add(getBody());
            counter = 0;
        }
        body = (String)message.getBody();
        counter++;
    }
}
