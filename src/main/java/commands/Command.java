package commands;

public abstract class Command {

    public abstract Object getMessage();

    public abstract String getDecorated();

    public abstract Command getAccumulated(Command other);

    public abstract Boolean equalsCommand(Command other);

}
