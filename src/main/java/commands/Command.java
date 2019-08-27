package commands;

public abstract class Command {

    Object message;

    public Object getMessage() {
        return message;
    }

    public abstract String getDecorated();

    public abstract Command getAccumulated(Command other);

    public abstract Boolean equalsCommand(Command other);

}
