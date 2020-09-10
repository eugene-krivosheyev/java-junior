package demo.exception;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            new Controller().log("some message");
        } catch (LogException e) {
            e.printStackTrace();
        }
        //---
    }
}

class Controller {
    private Saver saver = new Saver();

    public void log(String message) throws LogException {
        //region t-c
        Connection connection = null;
        LogException logException = null;
        try {
            //.....
            connection = null; //openConnection()
            saver.save(message);
            //---
        } catch (NullPointerException | SaveException e) {
            //.......
            //e.printStackTrace();
            logException = new LogException("message #18", e);
            throw logException;
        } finally {
            if (connection != null) {
                try {
                    connection.close(); // -> NPE: Suppression
                } catch (SQLException closeException) {
                    if (logException != null) {
                        closeException.addSuppressed(logException);
                    }
                    throw new LogException(closeException);
                }
            }
        }
        //endregion
    }
}

class Saver implements AbstractSaver {
    public void save(String message) throws SaveException {
        //...
        try {
            throw new IOException("some error definition");
        } catch (Exception e) {
            //e.printStackTrace();
            throw new SaveException("file abc.txt", e);
        }
        //---
    }
}

interface AbstractSaver {
    void save(String message) throws SaveException;
}

class LogException extends Exception {
    public LogException() {
    }

    public LogException(String message) {
        super(message);
    }

    public LogException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogException(Throwable cause) {
        super(cause);
    }

    public LogException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}