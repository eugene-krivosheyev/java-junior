package ooaddemo;


abstract class LoggerController {
    //Creator
    private final LoggerFilter filter = new MessageContentLoggerFilter();
    private final LoggerSaver saver = null;

    private Accumulator currentAccumulator;
    private Accumulator byteAccumulator;
    private Accumulator stringAccumulator;

    //Dependency Injection: constructor | setter
    public LoggerController(Accumulator currentAccumulator) {
        this.currentAccumulator = currentAccumulator;
    }


    /**
     * OCP: Open Closed Principle
     * DIP: Dependency Inversion Principle
     */
    /**
     * DP: Template Method vs Strategy
     */
    public final void log(String message) {
        if (!this.filter.filter(message)) {
            this.saver.save(encode(message));
        }
    }

    protected abstract Object encode(String message);

    public static void uM() {

    }
}