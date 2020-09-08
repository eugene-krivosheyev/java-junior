package com.acme.edu.command;

public interface LoggerCommand {

    public boolean isSameType(LoggerCommand currentLoggerCommand);

    public LoggerCommand accumulate(LoggerCommand newLoggerCommand);
}
