package demo;

public class ExceptionsDemo {
    public static void main(String[] args) {
        //RQ + domain: main flow VS alternate flow
        //Exception: break -> alt flow (code branch) + object (type, properties)
        try {
            new Controller().log("null");
        } catch (RuntimeException e) { //LogOperationException IS-A RuntExc
            //User communication
            e.printStackTrace();
        }
    }
}

/**
 * "Mediator"? + "Controller": request
 * API
 */
class Controller {
    public void log(String message) {
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
    public void log(String message) {
        try {
            new Repo().save(message);
            //....
            //....
        } catch (RuntimeException e) {
//            1. Full handing: Retrying, Redundency -> NRFs (fail-over)
//            2. Fail: raw case exception VS wrapper/business exception
            throw new LogOperationException("business message", e);
        }
        //.....
    }
}

class Repo {
    public void save(String message) {
        throw new RuntimeException("low-level message");
    }
}

class LogOperationException extends RuntimeException {
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