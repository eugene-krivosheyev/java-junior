package buffer;

import message.IntMessage;
import message.Message;

public class Int2dArrayBuffer extends IntArrayBuffer {

    @Override
    public void accumulate(Message integers) {
        for (Integer integer : (Integer[])integers.getBody()) {
            super.accumulate(new IntMessage(integer));
        }
    }
}
