package com.acme.edu.command;

public class LoggerCommand {
    protected String message;

    public String getMessage(){ return this.message;}
    public String clearBuffer(){}

    public boolean isSameType(LoggerCommand currentLoggerCommand) {
    }

    public LoggerCommand accumulate(LoggerCommand newLoggerCommand) {
    }
}
