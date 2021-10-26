package demo;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class ExceptionsDemo {
    public static void main(String[] args) throws LogException, SQLException {
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

    public void log() throws LogException, SQLException {
        service.log();
        //....
    }
}

class Service {
    private Repository repository;

    Service(Repository repository) {
        this.repository = repository;
    }

    public void log() throws LogException, SQLException {
        try(Repository repository = new Repository()) {
            repository.save();
            //...
        } catch (IllegalStateException | IllegalArgumentException e) {
            //Retry, Scaling,
//            e.printStackTrace();
            throw new LogException("!!!!", e);
        } catch (RuntimeException e) {
//
        } catch (Exception e) {
            e.printStackTrace();
        }
        //...
    }
}

//DAO / Repo
class Repository implements Closeable {
    public void save() {
            throw new IllegalStateException("ERROR #135");
        //...
    }

    @Override
    public void close() throws IOException {

    }
}

class LogException extends Exception {
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