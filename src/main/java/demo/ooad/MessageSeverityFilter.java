package demo.ooad;

public class MessageSeverityFilter implements MessageFilter {
    private SeverityLevel minLevelForLogging;

    public MessageSeverityFilter(SeverityLevel minLevelForLogging) {
        this.minLevelForLogging = minLevelForLogging;
    }

    @Override
    public boolean filter(String message, SeverityLevel severity) {
        switch (severity) {
            case INFO: if (minLevelForLogging == SeverityLevel.INFO) return true;
            case WARN:
            case ERROR:
        }
        return true;
    }
}
