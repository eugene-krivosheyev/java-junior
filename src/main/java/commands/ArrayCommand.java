package commands;

import java.util.Arrays;

public class ArrayCommand extends Command {

    private static final String ARRAY_PREFIX = "primitives array: ";

    public ArrayCommand(int[] message) {
        super.message = message;
    }

    @Override
    public String getDecorated() {
        return ARRAY_PREFIX + Arrays.toString(((int[]) message));
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
