package demo.templatemethod;

public class Demo {
    public static void main(String[] args) {
        MessageFilterConsoleSaver filterAndSaver = new MessageFilterConsoleSaver();
        Logger logger = new Logger(
                filterAndSaver,
                filterAndSaver
        );

        logger.log();

        System.out.println(LoggerSaver.MY_CONST);
    }
}

/**
 * State/Strategy
 */
class Logger {
    private LoggerFilter filter;
    private LoggerSaver saver;

    public Logger(LoggerFilter filter, LoggerSaver saver) {
        this.filter = filter;
        this.saver = saver;
    }

    public void log() {
        if (filter.filter()) {
            saver.save();
        }
    }
}

interface LoggerFilter {
    public boolean filter();
}

interface LoggerSaver {
    public static final int MY_CONST = 0;
    void save();
}

class MessageFilterConsoleSaver extends Object implements LoggerFilter, LoggerSaver {
    private boolean filtered;

    @Override
    public boolean filter() {
        this.filtered = true;
        return false;
    }

    @Override
    public void save() {
        System.out.println(filtered);
    }
}