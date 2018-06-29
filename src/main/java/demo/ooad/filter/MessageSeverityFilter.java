package demo.ooad.filter;

import demo.ooad.SeverityLevel;
import demo.ooad.message.LogSeverityMessage;

public class MessageSeverityFilter implements MessageFilter {
    private SeverityLevel minLevelForLogging;

    public MessageSeverityFilter(SeverityLevel minLevelForLogging) {
        this.minLevelForLogging = minLevelForLogging;
    }

    @Override
    public boolean filter(LogSeverityMessage message) {
        return message.compareTo(minLevelForLogging);
    }
}
