package com.acme.edu.ooaddemo;

public class XmlConfigFilterFactory {
    public static LoggerFilter create(int level) {
        return new SeverityLevelLoggerFilter();
    }
}
