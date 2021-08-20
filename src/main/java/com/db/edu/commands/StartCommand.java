package com.db.edu.commands;

public class StartCommand extends Command {

    public StartCommand() {}

    public Command accumulate(Command another) {
        return another;
    }

    public void finishCommand() {
    }
}
