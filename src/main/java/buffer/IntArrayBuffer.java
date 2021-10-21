package buffer;

import message.IntMessage;
import message.Message;

public class IntArrayBuffer extends IntBuffer {

    public void accumulate(Message integers) {
        for (Integer integer : (Integer[])integers.getBody()) {
            super.accumulate(new IntMessage(integer));
        }
    }
}
