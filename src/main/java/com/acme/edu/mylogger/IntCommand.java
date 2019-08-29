package com.acme.edu.mylogger;

public class IntCommand implements Command {
    private final static String PRIMITIVE_PREFIX = "primitive: ";
    private int message;

    IntCommand(int message) {
        this.message = message;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof IntCommand;
    }

    @Override
    public boolean isOverflow() {
        if (message < 0) {
            throw new ArithmeticException();
        }
        return false;
    }

    @Override
    public Command accumulate(Command other) {
        try {
            (new IntCommand((int)this.getMessage() + (int)other.getMessage())).isOverflow();
        }
        catch (ArithmeticException e) {
            //e.printStackTrace();
            throw new ArithmeticException("Overflow");
        }
        return new IntCommand((int)this.getMessage() + (int)other.getMessage());
    }

    @Override
    public String getDecorated() {
        return PRIMITIVE_PREFIX + this.message;
    }

    @Override
    public Object getMessage() {
        return message;
    }
}
