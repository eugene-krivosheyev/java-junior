package demo.templatemethod;

import java.util.ArrayList;
import java.util.Collection;

public class Demo {
    public static void main(String[] args) {
        MessageFilterConsoleSaver filterAndSaver = new MessageFilterConsoleSaver();
        Logger logger = new Logger(
                filterAndSaver,
                filterAndSaver
        );

        logger.log();

        System.out.println(LoggerSaver.MY_CONST);
        LoggerFilter.someLogic();
        filterAndSaver.defaultSave();

        Collection<String> list = new ArrayList<>();
        list.stream()
                .filter(s -> s.length() < 5)
                .map(Integer::parseInt)
                .forEach(System.out::println);

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

    /**
     * Defender || Default Methods
     */
    public default void defaultSave() {
        System.out.println(this.getState() + "HW!!");
    }

    boolean getState();

    /**
     * Static implementation: any visibility
     */
    static void someLogic() {

    }
}

interface LoggerSaver {
    public static final int MY_CONST = 0;
    void save();
}

interface SuperSaver extends LoggerSaver, LoggerFilter {

}

/**
 * Diamond implementation:
 * http://www.codenuclear.com/default-and-static-methods-in-interfaces/
 */
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