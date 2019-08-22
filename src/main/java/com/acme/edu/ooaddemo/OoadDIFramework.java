package com.acme.edu.ooaddemo;

public class OoadDIFramework {
    public static void main(String[] args) {
        //Framework responsibility 1 : app building
        final Logger logger = new Logger(
            new SeverityLevelLoggerFilter(),
            new ConsoleLoggerSaver()
        ); // -> xml, json, yaml: build on configuration!

        //Framework responsibility 2 : request handling
    }
}

class Logger {
    //Filed DI (Reflection API -> CGLib | ByteBuddy)
    private LoggerFilter filter;
    private LoggerSaver saver;

    //Constructor DI
    Logger(LoggerFilter filter, LoggerSaver saver) {
        this.filter = filter;
        this.saver = saver;
    }

    //Setter DI
    public void setSaver(LoggerSaver saver) {
        this.saver = saver;
    }

    public void log(String message, int severityLevel) {
        if (!filter.isFiltered(message, severityLevel)) {
            saver.save(message);
        }
    }
}

class SeverityLevelLoggerFilter implements LoggerFilter {
    private static final int MAX_ALLOWED_SEVERITY = 5;

    @Override
    public boolean isFiltered(String message, int severityLevel) {
        return severityLevel < MAX_ALLOWED_SEVERITY;
    }
}

class ConsoleLoggerSaver implements LoggerSaver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}