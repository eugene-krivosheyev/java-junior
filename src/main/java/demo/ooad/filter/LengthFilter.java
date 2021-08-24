package demo.ooad.filter;

import demo.ooad.domain.Message;

public class LengthFilter implements Filter {
    private final int treshold;

    public LengthFilter(int treshold) {
        this.treshold = treshold;
    }

    @Override
    public boolean filter(Message message) {
        return message.getBody().length() > treshold;
    }
}
