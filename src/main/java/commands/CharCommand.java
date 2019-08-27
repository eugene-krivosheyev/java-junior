package commands;

public class CharCommand extends Command {
    private static final String CHAR_PREFIX = "char: ";
    private char message;

    public CharCommand(char message) {
        this.message = message;
    }

    @Override
    public Character getMessage() {
        return message;
    }

    @Override
    public String getDecorated() {

        return CHAR_PREFIX + message;
    }
    // todo separate interface

    @Override
    public Command getAccumulated(Command other) {
        return new CharCommand(message);
    }

    @Override
    public Boolean equalsCommand(Command other) {
        return other instanceof CharCommand;
    }

}
