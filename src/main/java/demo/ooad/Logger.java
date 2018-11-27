package demo.ooad;

public class Logger {
    public void log(String message, int severity) {
        if(!filter(message, severity)) {
            save(message);
        }
    }

    private void save(String message) {

    }

    private boolean filter(String message, int severity) {
        return false;
    }
}
