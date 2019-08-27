package commands;

public class IntCommand extends Command {

    private static final String PRIMITIVE_PREFIX = "primitive: ";

    public IntCommand(int message) {
        super.message = message;
    }

    @Override
    public String getDecorated() {
        return PRIMITIVE_PREFIX + (int)message;
    }

    @Override
    public Command getAccumulated(Command other) {
        return new IntCommand((int)message + (int)other.getMessage());
    }

    @Override
    public Boolean equalsCommand(Command other) {
        return other instanceof IntCommand;
    }

}
