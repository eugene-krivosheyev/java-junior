package exceptions;

import java.io.Closeable;
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
    public void log(String message) throws LogOperationException {

        try (Saver saver = new ConsoleSaver()) {
            saver.save("");
        } catch (SaveException | RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        //region t-c
        Saver saver = null;
        LogOperationException logOperationException = null;
        try {
            saver = new ConsoleSaver();
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
            if (saver != null) {
                try {
                    saver.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

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

interface Saver extends AutoCloseable  {
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

    @Override
    public void close() throws Exception {

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