package demo;

public class ExceptionsDemo {
    public static void main(String[] args) {
        //RQ + domain: main flow VS alternate flow
        //Exception: break -> alt flow (code branch) + object (type, properties)

        try {
            new Controller().log(null);
        } catch (RuntimeException e) {
            //сообщение в UI о отказе, но нет остановки программы
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

        new Service().log(message);
    }
}

/**
 * "Service": business logic
 */
class Service {
    public void log(String message) {
        new Repo().save(message);
    }
}

class Repo {
    public void save(String message) {
        throw new RuntimeException("runtime message");
    }
}
