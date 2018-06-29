package demo.ooad.message;

import demo.ooad.SeverityLevel;

public class LogInfoMessage extends LogSeverityMessage {
    public LogInfoMessage(String message, SeverityLevel severityLevel) {
        super(message, severityLevel);
    }

    @Override
    public boolean filter(SeverityLevel minLevelForLogging) {
        return minLevelForLogging == SeverityLevel.INFO;
    }
}
