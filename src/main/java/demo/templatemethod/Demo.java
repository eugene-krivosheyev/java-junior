package demo.templatemethod;

public class Demo {
    public static void main(String[] args) {
        Logger logger = new ConsoleMessageFilteringLogger();
        logger.log();
    }
}

/**
 * Template Method
 */
abstract class Logger {
    protected abstract void save();

    protected abstract boolean filter();

    public void log() {
        if (this.filter()) {
            this.save();
        }
    }
}

class ConsoleMessageFilteringLogger extends Logger {
    @Override
    protected void save() {
        System.out.println();
    }

    @Override
    protected boolean filter() {
        return false;
    }
}

