package ooaddemo;


abstract class LoggerController {
    //Creator
    private final LoggerFilter filter = new MessageContentLoggerFilter();
    private final LoggerSaver saver = null;

    private Accumulator currentAccumulator;
    private Accumulator byteAccumulator;
    private Accumulator stringAccumulator;

    //Dependency Injection: constructor | setter
    public LoggerController(Accumulator byteAccumulator, Accumulator stringAccumulator) {
        this.byteAccumulator = byteAccumulator;
        this.stringAccumulator = stringAccumulator;
    }

    /**
     * OCP: Open Closed Principle
     * DIP: Dependency Inversion Principle
     */
    /**
     * DP: Template Method
     */
    public final void log(String message) {
        if (!filter.filter(message)) {
            saver.save(encode(message));
        }
    }

    protected abstract Object encode(String message);
}