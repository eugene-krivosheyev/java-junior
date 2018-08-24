package ooaddemo.filter;

import ooaddemo.controller.SeverityLevel;

public class FilterFactory {
    public LoggerFilter create(String message, SeverityLevel level) {
        return new MessageContentLengthLoggerFilter(message);
    }
}
