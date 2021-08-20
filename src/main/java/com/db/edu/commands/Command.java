package com.db.edu.commands;

public abstract class Command {

    StringBuilder builder = new StringBuilder();

    public abstract Command accumulate(Command another);

    public abstract void finishCommand();

    public String getLogMessage() {
        return builder.toString();
    }

}
