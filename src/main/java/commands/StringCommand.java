package commands;

public class StringCommand extends Command {

    private final static String STRING_PREFIX = "string: ";
    private final String message;
    private int repeat;

    public StringCommand(String message, int repeat) {
        this.message = message;
        this.repeat = repeat;
    }

    public StringCommand(String message) {
        this(message, 0);
    }


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getDecorated(){
        String decoratedStr = STRING_PREFIX + message;
        return repeat == 0? decoratedStr: decoratedStr + " (x" + ++repeat + ")";
    }


    @Override
    public Command getAccumulated(Command other) {
        return new StringCommand(message, repeat + 1);
    }

    @Override
    public Boolean equalsCommand(Command other) {
        return other instanceof StringCommand && message.equals(other.getMessage()) ;
    }

}
