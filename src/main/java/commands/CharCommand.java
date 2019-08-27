package commands;

public class CharCommand extends Command {
    private static final String CHAR_PREFIX = "char: ";
    private char symbol;

    public CharCommand(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getDecorated() {

        return CHAR_PREFIX + symbol;
    }
    // todo separate interface

    @Override
    public Command getAccumulated(Command other) {
        return new CharCommand(symbol);
    }

    @Override
    public Boolean equalsCommand(Command other) {
        return other instanceof CharCommand;
    }

}
