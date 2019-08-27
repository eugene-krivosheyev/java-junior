package commands;

public class ReferenceCommand extends Command {

    private static final String REFERENCE_PREFIX = "reference: ";
    private Object message;

    public ReferenceCommand(Object message) {
        this.message = message;
    }

    @Override
    public Object getMessage() {
        return message;
    }

    @Override
    public String getDecorated() {
        return REFERENCE_PREFIX + message;
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
