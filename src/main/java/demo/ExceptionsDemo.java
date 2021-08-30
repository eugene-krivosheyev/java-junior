package demo;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

public class ExceptionsDemo {
    public static void main(String[] args) {
        //RQ + domain: main flow VS alternate flow
        //Exception: break -> alt flow (code branch) + object (type, properties)
        try {
            new Controller().log("null");
        } catch (RuntimeException e) { //LogOperationException IS-A RuntExc
            //User communication
            e.printStackTrace();
        } catch (LogOperationException e) {
            e.printStackTrace();
        }
    }
}

/**
 * "Mediator"? + "Controller": request
 * API
 */
class Controller {
    public void log(String message) throws LogOperationException {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("message not valid");
        }

        try {
            new Service().log(message);
        } catch (Exception e) {
            //1. Full handing: Retrying, Redundency -> NRFs (fail-over)
            //2. Fail: raw case exception VS wrapper/business exception
            throw e;
        }
    }
}

/**
 * "Service": business logic
 */
class Service {
    public void log(String message) throws LogOperationException {
        try (Repo repo = new Repo()) { //Constructor || Factory Method e.g. _open_
            repo.save(message); // -> RuntExc
            return;
            //....
        } catch (ArithmeticException | NullPointerException e) {
                //....
                //....
                //....
        } catch (Exception e) { // -> RuntExc!!!!
//            1. Full handing: Retrying, Redundency -> NRFs (fail-over)
//            2. Fail: log + raw case exception VS wrapper/business exception
            throw new LogOperationException("business operation exception", e);
        } // finally with close()
    }
}

class Repo implements AutoCloseable {
    public void save(String message) throws IOException {
        throw new IOException("low-level exception");
    }

    @Override
    public void close() throws Exception {
        throw new Exception("close exception");
    }
}

class LogOperationException extends Exception {
    public LogOperationException() {
        super();
    }

    public LogOperationException(String message) {
        super(message);
    }

    public LogOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogOperationException(Throwable cause) {
        super(cause);
    }
}