package com.acme.edu;

import com.acme.edu.commands.Command;

/**
 * Created by kate-c on 25/08/2019.
 */
public class CommandAndFlushOptional {
    private Command command;
    private boolean ifFlushNeeded = false;

    public CommandAndFlushOptional(Command command, boolean shouldBeFlushed) {
        this.command = command;
        this.ifFlushNeeded = shouldBeFlushed;
    }

    public Command getCommand() {
        return command;
    }

    public boolean ifFlushNeeded() {
        return ifFlushNeeded;
    }
}
