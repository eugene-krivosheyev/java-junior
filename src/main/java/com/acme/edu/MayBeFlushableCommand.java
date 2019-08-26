package com.acme.edu;

/**
 * Created by kate-c on 25/08/2019.
 */
public class MayBeFlushableCommand {
    private Command command;
    private boolean shouldBeFlushed = false;

    public MayBeFlushableCommand(Command command, boolean shouldBeFlushed) {
        this.command = command;
        this.shouldBeFlushed = shouldBeFlushed;
    }

    public Command getCommand() {
        return command;
    }

    public boolean shouldBeFlushed() {
        return shouldBeFlushed;
    }
}
