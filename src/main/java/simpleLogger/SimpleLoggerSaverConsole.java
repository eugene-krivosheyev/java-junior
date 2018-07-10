package simpleLogger;

public class SimpleLoggerSaverConsole implements SimpleLoggerSaver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
