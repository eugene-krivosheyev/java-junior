package commands;

public class BooleanCommand extends Command {

    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private Boolean message;

    public BooleanCommand(Boolean message) {
        this.message = message;
    }

    @Override
    public Boolean getMessage() {
        return message;
    }

    @Override
    public String getDecorated() {
        return PRIMITIVE_PREFIX + message;
    }

    @Override
    public Command getAccumulated(Command other) {
        return new BooleanCommand(message);
    }

    @Override
    public Boolean equalsCommand(Command other) {
        return other instanceof BooleanCommand;
    }
}
