package com.acme.edu.commands;

public class CommandAccumulateInfo {
    private Command command;
    private String message;

    public CommandAccumulateInfo(Command command, String message) {
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