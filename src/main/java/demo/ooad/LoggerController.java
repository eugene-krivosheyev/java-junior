package demo.ooad;

public class LoggerController {
    private final LengthFilter lengthFilter = new LengthFilter();
    private final ConsoleSaver consoleSaver = new ConsoleSaver();

    /**
     * Public API
     * @param message
     */
    public void log(Message message) {
        if (!lengthFilter.filter(message)) {
            consoleSaver.save(message);
        }
    }
}
