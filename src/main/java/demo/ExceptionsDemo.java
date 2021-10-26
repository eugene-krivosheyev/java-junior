package demo;

public class ExceptionsDemo {
    public static void main(String[] args) {
        final Controller controller = new Controller(new Service(new Repository()));
        controller.log();
        //....
    }
}

class Controller {
    private Service service;

    Controller(Service service) {
        this.service = service;
    }

    public void log() {
        service.log();
        //....
    }
}

class Service {
    private Repository repository;

    Service(Repository repository) {
        this.repository = repository;
    }

    public void log() {
        try {
            repository.save();
            //...
        } catch (IllegalStateException | IllegalArgumentException e) {
            //Retry, Scaling,
//            e.printStackTrace();
            throw new LogException("!!!!", e);
        } catch (RuntimeException e) {

        } finally {
            repository.close();
        }
        //...
    }
}

//DAO / Repo
class Repository {
    public void save() {
        if (true) {
            throw new IllegalStateException("ERROR #135");
        }
        //...
    }

    public void close() {

    }
}

class LogException extends RuntimeException {
    public LogException() {
        super();
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

    protected LogException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}