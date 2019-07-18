package com.acme.edu.ooad;

public class Command {
    private String message;
    private int severityLevel;

    {
        System.out.println("ку-ку");
    }

    public Command(String message, int severityLevel) {
        this.message = message;
        this.severityLevel = severityLevel;
    }

    public Command(String message) {
        this(message, 0);
        System.out.println();
    }

    public String getMessage() {
        return message;
    }

    public int getSeverityLevel() {
        return severityLevel;
    }

    public boolean isAllowed(int max_level) {
        return this.severityLevel > max_level;
    }
}

class StringCommand extends Command {
    private String message;

    public StringCommand(String messsage, int level) {
        super(messsage, level);
    }

    public boolean equals(Command other) {
        return (other instanceof StringCommand) && this.message.equals(((StringCommand) other).message);
    }

    public void strMethod() {

    }
}