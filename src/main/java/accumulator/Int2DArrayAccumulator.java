package accumulator;

import message.IntMessage;
import message.Message;

public class Int2DArrayAccumulator extends IntArrayAccumulator {

    @Override
    public void accumulate(Message integers) {
        for (Integer integer : (Integer[])integers.getBody()) {
            super.accumulate(new IntMessage(integer));
        }
    }
}
