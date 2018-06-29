package demo.ooad.filter;

import demo.ooad.message.LogSeverityMessage;

public class MessageOddLengthFilter implements MessageFilter {
    @Override
    public boolean filter(LogSeverityMessage message) {
        return message.getMessage().length() % 2 == 0;
    }
}
