package com.db.edu.saver;

public class SaveException extends Exception {
    public SaveException() {
        super();
    }

    public SaveException(String message) {
        super(message);
    }

    public SaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaveException(Throwable cause) {
        super(cause);
    }
}
