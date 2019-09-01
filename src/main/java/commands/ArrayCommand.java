package commands;

import java.util.Arrays;

public class ArrayCommand extends Command {

    private static final String ARRAY_PREFIX = "primitives array: ";
    private final Object message;

    public ArrayCommand(Object message) {
        this.message = message;
    }

    @Override
    public Object getMessage() {
        return message;
    }

    // todo
    @Override
    public String getDecorated() {
        String output = ARRAY_PREFIX;

        if (message instanceof int[]) {
            output = Arrays.toString((int[])message);    //int[] overload
        }
        else  if (message instanceof String[]){
            output = Arrays.toString((String[])message);
        } else if (message instanceof Object[]) {
            output = Arrays.toString((Object[])message); //Object[] overload
        }


        return ARRAY_PREFIX + output;
    }

    @Override
    public Command getAccumulated(Command other) {
        return new ArrayCommand(other.getMessage());
    }

    @Override
    public Boolean equalsCommand(Command other) {
        return other instanceof ArrayCommand;
    }

}
