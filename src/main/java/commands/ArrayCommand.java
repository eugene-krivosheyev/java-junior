package commands;

import java.util.Arrays;

public class ArrayCommand extends Command {

    private static final String ARRAY_PREFIX = "primitives array: ";
    private final int[] message;

    public ArrayCommand(int[] message) {
        this.message = message;
    }

    @Override
    public int[] getMessage() {
        return message;
    }

    @Override
    public String getDecorated() {
        return ARRAY_PREFIX + Arrays.toString(message);
    }

    @Override
    public Command getAccumulated(Command other) {
        return new ArrayCommand((int[]) other.getMessage());
    }

    @Override
    public Boolean equalsCommand(Command other) {
        return other instanceof ArrayCommand;
    }

}
