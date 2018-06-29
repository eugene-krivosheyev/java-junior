package demo.ooad.filter;

import demo.ooad.SeverityLevel;
import demo.ooad.message.LogSeverityMessage;

public class MoonPhaseMessageFilter implements MessageFilter {
    @Override
    public boolean filter(LogSeverityMessage message) {
        return false;
    }
}
