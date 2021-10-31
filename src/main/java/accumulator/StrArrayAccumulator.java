package accumulator;

import message.Message;
import message.StringMessage;

public class StrArrayAccumulator extends StrAccumulator {

    @Override
    public void accumulate(Message message) {
        for (String string : (String[])message.getBody()) {
            super.accumulate(new StringMessage(string));
        }
    }
}
