package buffer;

import message.Message;

import java.util.ArrayList;

public class BoolBuffer implements Buffer {

    private OutOfOrderLineKeeper lineKeeper = new OutOfOrderLineKeeper("primitive: ");

    @Override
    public String getBody() {
        return null;
    }

    @Override
    public ArrayList<String> getExtraordinaryBody() {
        return lineKeeper.getExtraordinaryBody();
    }

    @Override
    public void accumulate(Message bool) {
        lineKeeper.add(bool.getBody().toString());
    }
}
