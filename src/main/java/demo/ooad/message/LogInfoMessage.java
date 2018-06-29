package demo.ooad.message;

import demo.ooad.SeverityLevel;

public class LogInfoMessage extends LogSeverityMessage {
    public LogInfoMessage(String message, SeverityLevel severityLevel) {
        super(message, severityLevel);
    }

    @Override
    public String getMessage() {
        return "[INFO] " + super.getMessage();
    }

    @Override
    public boolean compareTo(SeverityLevel minLevelForLogging) {
        return minLevelForLogging == SeverityLevel.INFO;
    }
}


class InheritanceDemo {
    public static void main(String[] args) {
        LogSeverityMessage message
                = new LogInfoMessage("test message", SeverityLevel.WARN);
        message.getMessage();
    }
}