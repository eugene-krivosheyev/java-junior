package com.acme.edu.commands;

public class IntCommand implements Command {
    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return Command.PRIMITIVE_PREFIX + message;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof IntCommand;
    }

    @Override
    public IntCommand accumulate(Command other) {
        if (other instanceof IntCommand) {
            int otherMessage = ((IntCommand) other).getMessage();
            if ((long) otherMessage + this.message > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("Overflow accumulation is not supported yet");
            }
            return new IntCommand(this.message + otherMessage);
        } else {
            throw new IllegalArgumentException("Can't accumulate IntCommand with other Command subclass");
        }
    }

    @Override
    public Integer getMessage() {
        return message;
    }
}
