package commands;

import java.util.Arrays;

public class ReferenceCommand extends Command {

    private static final String REFERENCE_PREFIX = "reference: ";
    private Object message;

    private static final String ARRAY_PREFIX = "primitives array: ";

    public ReferenceCommand(Object message) {
       this.message = message;
    }

    @Override
    public Object getMessage() {
        return message;
    }

    @Override
    public String getDecorated() {

//        return REFERENCE_PREFIX + message;
        String output = "";

        if (message instanceof int[]) {
            output = ARRAY_PREFIX;
            output += Arrays.toString((int[])message);    //int[] overload
        }
        else  if (message instanceof String[]){
            output = ARRAY_PREFIX;
            output += Arrays.toString((String[])message);
        } else if (message instanceof Object) {
            output = REFERENCE_PREFIX;
            output += message; //Object[] overload
        }


        return output;

    }

    @Override
    public Command getAccumulated(Command other) {
        return new ReferenceCommand(message);
    }

    @Override
    public Boolean equalsCommand(Command other) {
        return other instanceof ReferenceCommand;
    }
}
