package exeption;

public class EmptyAccumulatorException extends RuntimeException {
    public EmptyAccumulatorException() {
        super();
    }

    public EmptyAccumulatorException(String message) {
        super(message);
    }

    public EmptyAccumulatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyAccumulatorException(Throwable cause) {
        super(cause);
    }

    protected EmptyAccumulatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
