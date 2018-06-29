package demo.ooad;

import demo.ooad.message.LogSeverityMessage;

public class MessageSeverityFilter implements MessageFilter {
    private SeverityLevel minLevelForLogging;

    public MessageSeverityFilter(SeverityLevel minLevelForLogging) {
        this.minLevelForLogging = minLevelForLogging;
    }

    @Override
    public boolean filter(LogSeverityMessage message) {
        return message.filter(minLevelForLogging);
    }
}
