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
        LogOperationException lopex = null;
        Repo repo = null; //Constructor || Factory Method e.g. _open_
        try {
            repo = new Repo();
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
            lopex = new LogOperationException("business operation exception", e);
            throw lopex;
        } finally {
            if (repo != null) {
                try {
                    repo.close(); // -> NPE
                } catch (RuntimeException e) { // -> Suppression!!!!
                    if (lopex != null) {
                        e.addSuppressed(lopex);
                    }
                    throw e;
                }
            }
        }
        //.....
    }
}

class Repo {
    public void save(String message) {
        throw new RuntimeException("low-level exception");
    }

    public void close() {
        throw new RuntimeException("close exception");
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