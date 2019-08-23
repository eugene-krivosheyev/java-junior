package com.acme.edu.Commands;

public class CommandAccumulateInfo {
    private Command command;
    private String message;
    int code;
    public CommandAccumulateInfo(Command command, String message, int code) {
        this.command = command;
        this.message = message;
    }


    public Command getCommand() {
        return command;
    }

    public String getMessage() {
        return message;
    }
}