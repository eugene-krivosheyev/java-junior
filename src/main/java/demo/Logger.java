package demo;

public class Logger {
    /**
     * Creational Patterns
     */
    private final Filter filter; //DI
    private final Saver saver = SaverFactory.create();

    public Logger(Filter filter) {
        this.filter = filter;
    }

    public void log(String message) {
        if (filter.filter(message)) {
            saver.save(message);
        }
    }
}

abstract class Logger2 {
    public void log() {
        //------- 1M
        //-------
        //-------
        filter();
        //-------
        //-------
        //-------
    }

    abstract void filter();
}

class ContentFilterLogger extends Logger2 {
    @Override
    void filter() {

    }
}




