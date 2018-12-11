package demo.proceduraltoooad;

/**
 * Stateful!!!
 */
public class LogService {
    private ConsolePrinter saver;

    public LogService(ConsolePrinter saver) {
        this.saver = saver;
    }

    public void log(IntMessage message) {
        saver.print(message.getDecoratedMessage());
    }
}
