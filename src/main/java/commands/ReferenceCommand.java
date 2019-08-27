package commands;

public class ReferenceCommand extends Command {

    private static final String REFERENCE_PREFIX = "reference: ";
    private Object reference;

    public ReferenceCommand(Object reference) {
        this.reference = reference;
    }

    @Override
    public String getDecorated() {
        return REFERENCE_PREFIX + reference;
    }

    @Override
    public Command getAccumulated(Command other) {
        return new ReferenceCommand(reference);
    }

    @Override
    public Boolean equalsCommand(Command other) {
        return other instanceof ReferenceCommand;
    }
}
