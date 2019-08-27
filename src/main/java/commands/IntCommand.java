package commands;

public class IntCommand extends Command {

    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private final int message;

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

    @Override
    public Boolean equalsCommand(Command other) {
        return other instanceof IntCommand;
    }

}
