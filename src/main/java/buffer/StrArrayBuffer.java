package buffer;

import message.Message;
import message.StringMessage;

import java.util.ArrayList;
import java.util.Objects;

public class StrArrayBuffer extends StrBuffer {

    public void accumulate(Message message) {
        for (String string : (String[])message.getBody()) {
            super.accumulate(new StringMessage(string));
        }
    }
}
