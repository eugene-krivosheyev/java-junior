package demo.ooad;

public class Logger {
    public void log(String message) {
        if (filter(message)) {
            save(message);
        }
    }

    private void save(String message) {

    }

    private boolean filter(String message) {
        return false;
    }
}
