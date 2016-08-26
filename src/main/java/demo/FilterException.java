package demo;

public class FilterException extends Exception {
    public FilterException() {
        super();
    }

    public FilterException(String message) {
        super(message);
    }

    public FilterException(String message, Throwable cause) {
        super(message, cause);
    }

    public FilterException(Throwable cause) {
        super(cause);
    }

    protected FilterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
