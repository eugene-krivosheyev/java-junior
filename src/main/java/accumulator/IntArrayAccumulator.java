package accumulator;

import message.IntMessage;
import message.Message;

public class IntArrayAccumulator extends IntAccumulator {

    @Override
    public void accumulate(Message integers) {
        for (Integer integer : (Integer[])integers.getBody()) {
            super.accumulate(new IntMessage(integer));
        }
    }
}
