package commands;

public class ByteCommand extends Command {

    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private final byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public Byte getMessage() {
        return message;
    }

    // todo common logic to another class
    @Override
    public String getDecorated() {
        return PRIMITIVE_PREFIX + message;
    }

    @Override
    public Command getAccumulated(Command other) {
        return new ByteCommand((byte) (message + (byte)other.getMessage()));

    }

    // todo how to do best??
    
    public Command checkOverflow(Command other){
        byte maxValue = Byte.MAX_VALUE;

        if ((int)message + (int)other.getMessage() > maxValue){

        } else {

        }

        return new ByteCommand((Byte) other.getMessage());
        
    }

    @Override
    public Boolean equalsCommand(Command other) {
        return other instanceof ByteCommand;
    }
}
