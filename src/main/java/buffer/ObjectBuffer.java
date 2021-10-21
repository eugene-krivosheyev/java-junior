package buffer;

import message.Message;

import java.util.ArrayList;

public class ObjectBuffer implements Buffer {

    private OutOfOrderLineKeeper lineKeeper = new OutOfOrderLineKeeper("reference: ");

    @Override
    public String getBody() {
        return null;
    }

    @Override
    public ArrayList<String> getExtraordinaryBody() {
        return lineKeeper.getExtraordinaryBody();
    }

    @Override
    public void accumulate(Message object) {
        lineKeeper.add(object.getBody().toString());
    }

}
