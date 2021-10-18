package demo.ooad;

public class Logger {
    public static void log(String message) {
        if (!filter(message)) {
            save(decorate(message));
        }
    }


    /**
     * Stub implementations:
     */
    private static String decorate(String message) {
        return "decorated " + message;
    }

    private static boolean filter(String message) {
        return false;
    }

    private static void save(String decorate) {

    }
}
