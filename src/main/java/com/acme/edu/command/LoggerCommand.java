package com.acme.edu.command;

import com.acme.edu.exception.IntLogException;
import com.acme.edu.exception.StringLogException;

public interface LoggerCommand {

    public boolean isSameType(LoggerCommand currentLoggerCommand) throws StringLogException;

    public LoggerCommand accumulate(LoggerCommand newLoggerCommand) throws IntLogException;
}
