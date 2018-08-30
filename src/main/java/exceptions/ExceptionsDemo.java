package exceptions;

import java.io.IOException;

public class ExceptionsDemo {
    public static void main(String[] args) {
        try {
            LoggerFacade.log(" ");
        } catch (LogOperationException e) {
            e.printStackTrace();
        }
    }
}

class LoggerFacade {
    private static LoggerController controller = new LoggerController();
    public static void log(String message) throws LogOperationException {
        controller.log(message);
    }
}

class LoggerController {
    private Saver saver = new ConsoleSaver();
    public void log(String message) throws LogOperationException {
        //region t-c
        LogOperationException logOperationException = null;
        try {
            saver.save(message);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new LogOperationException("!!!", e);
        } catch (SaveException e) {
            e.printStackTrace();
            logOperationException = new LogOperationException(e);
            throw logOperationException;
        } catch (Exception e) {

        } finally {
            RuntimeException runtimeException = new RuntimeException();
            if (logOperationException != null) {
                runtimeException.addSuppressed(logOperationException);
            }
            throw runtimeException;
        }
        //endregion
        //
    }
}

interface Saver {
    void save(String message) throws SaveException;
}

class ConsoleSaver implements Saver {
    @Override
    public void save(String message) throws SaveException {
        if (message == null || "".equals(message)) {
            throw new SaveException(
                new IllegalArgumentException("Input message is crap.")
            );
        }
        //IO ops
        throw new SaveException(new IOException("ini.sys"));
    }
}

class LogOperationException extends Exception {
    public LogOperationException(String message) {
        super(message);
    }

    public LogOperationException(Throwable cause) {
        super(cause);
    }

    public LogOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}

class SaveException extends Exception {
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

    protected SaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}