package commands;

import exceptions.VarOverflowException;

public class IntCommand extends Command {

    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private final int message;
    private int maxValue = Integer.MAX_VALUE;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public Integer getMessage() {
        return message;
    }

    @Override
    public String getDecorated() {
        return PRIMITIVE_PREFIX + message;
    }

    @Override
    public IntCommand getAccumulated(Command other) {

        return new IntCommand(message + (int)other.getMessage());
    }
    // todo

    public Command checkOverflow(Command other){
        if ((long) message + Integer.valueOf(other.getMessage().toString()) > maxValue){
            throw new VarOverflowException("Overflow");
        }
        return new IntCommand((int)other.getMessage() + message);

    }

    @Override
    public Boolean equalsCommand(Command other) {
        return other instanceof IntCommand;
    }

}
