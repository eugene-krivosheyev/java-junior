package buffer;

import message.Message;

public class CharBuffer extends Buffer {

    public CharBuffer(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void accumulate(Message character) {
        extraOrdinary.add(character.getBody().toString());
    }
}
