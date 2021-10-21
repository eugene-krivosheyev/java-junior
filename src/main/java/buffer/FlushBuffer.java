package buffer;

import message.Message;

import java.util.ArrayList;

public class FlushBuffer implements Buffer {
    @Override
    public String getBody() {
        return null;
    }

    @Override
    public ArrayList<String> getExtraordinaryBody() {
        return null;
    }

    @Override
    public void accumulate(Message message) {

    }
}
