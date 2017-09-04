package demopackage;

public class DemoPackage {
    public static void main(String[] args) {
        OoadLogger logger = new OoadLogger(new StubSaver());
        logger.log(new StringLogMessage("string to save"));
    }
}

class OoadLogger {
    private Saver saver;

    OoadLogger(Saver saver) {
        this.saver = saver;
    }

    public void log(LogMessage logMessage) {
        saver.save(logMessage.getMessage());
    }
}

/**
 * @throws lkdfgklgkfjghkfgjh
 */
interface LogMessage {
    String getMessage();
}

class StringLogMessage implements LogMessage {
    private String state;

    StringLogMessage(String state) {
        this.state = state;
    }

    @Override
    public String getMessage() {
        return "formatted " + state;
    }
}

interface Saver {
    void save(String message);
}

class StubSaver implements Saver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
