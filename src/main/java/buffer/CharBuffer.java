package buffer;

import message.Message;

import java.util.ArrayList;

public class CharBuffer implements Buffer {

    private OutOfOrderLineKeeper lineKeeper = new OutOfOrderLineKeeper("char: ");

    @Override
    public String getBody() {
        return null;
    }

    @Override
    public ArrayList<String> getExtraordinaryBody() {
        return lineKeeper.getExtraordinaryBody();
    }

    @Override
    public void accumulate(Message character) {
        lineKeeper.add(character.getBody().toString());
    }
}
