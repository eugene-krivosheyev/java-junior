package com.db.edu.command;

public interface Command {
    public Command accumulate(Command command);
    public boolean canAccumulate(Command command);
    public String getDecoratedMessage();
}
