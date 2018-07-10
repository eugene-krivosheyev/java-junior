package com.db.edu.simplelogger.filter;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ContentSeverityFilter implements Filter<String> {

    private static final Pattern PATTERN;

    static {
        String regex = Arrays
                .stream(Severity.values())
                .map(Enum::toString)
                .collect(Collectors.joining("|", "\\[(", ")\\].*"));
        PATTERN = Pattern.compile(regex);
    }

    private final Severity limit;

    public ContentSeverityFilter(Severity limit) {
        this.limit = limit;
    }

    public boolean filter(String message) {
        if (message == null) {
            return false;
        }
        Matcher matcher = PATTERN.matcher(message);
        if (!matcher.matches()) {
            return false;
        }
        Severity messageSeverity = Severity.valueOf(matcher.group(1));
        return limit.level <= messageSeverity.level;
    }

    public enum Severity {
        DEBUG(1),
        INFO(2),
        ERROR(3);

        private int level;

        Severity(int level) {
            this.level = level;
        }
    }
}
