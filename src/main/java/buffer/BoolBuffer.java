package buffer;

import message.Message;

public class BoolBuffer extends Buffer {

    public BoolBuffer(String prefix) {
        this.prefix = prefix;
    }

    public void accumulate(Message bool) {
        extraOrdinary.add(bool.getBody().toString());
    }
}
