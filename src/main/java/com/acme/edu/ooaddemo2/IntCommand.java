package com.acme.edu.ooaddemo2;

public class IntCommand implements Command {
    private int severity;
    private int message;

    public IntCommand(int message, int severity) {
        this.severity = severity;
        this.message = message;
    }

    @Override
    public int getSeverity() {
        return severity;
    }

    @Override
    public String getDecorated() {
        return "primitive: " + message;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof IntCommand;
    }

    /**
     * @param other please check type for ...
     * @return
     */
    @Override
    public IntCommand accumulate(Command other) {
        if (other instanceof IntCommand) {
            return new IntCommand(this.message + ((IntCommand) other).getMessage(), this.severity);
        } else {
            throw new IllegalArgumentException("other");
        }
    }

    @Override
    public Integer getMessage() {
        return message;
    }
}
