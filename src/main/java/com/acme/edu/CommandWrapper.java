package com.acme.edu;

/**
 * Created by kate-c on 25/08/2019.
 */
public class CommandWrapper {
    Command command;
    boolean shouldBeFlushed = false;

    public CommandWrapper(Command command, boolean shouldBeFlushed) {
        this.command = command;
        this.shouldBeFlushed = shouldBeFlushed;
    }

    public Command getCommand() {
        return command;
    }

    public boolean isShouldBeFlushed() {
        return shouldBeFlushed;
    }
}
