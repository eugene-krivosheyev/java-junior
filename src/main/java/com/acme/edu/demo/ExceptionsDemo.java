package com.acme.edu.demo;

public class ExceptionsDemo {
    public static void main(String[] args) {
        final Controller controller = new Controller();
        LogOperationException logOperationException = null;
        try {
            controller.log();
        } catch (IllegalArgumentException | ArithmeticException e) {
//            e.printStackTrace();
        } catch (RuntimeException e) {
//            e.printStackTrace();
            logOperationException = new LogOperationException(e);
            throw logOperationException;
        } finally {
            if (controller != null) {
                try {
                    controller.close();
                } catch (RuntimeException e) {
                    if (logOperationException != null) {
                        e.addSuppressed(logOperationException);
                    }
                    throw e;
                }
            }
        }

    }
}

class Controller {
    private PuperSaver saver = new PuperSaver();
    private PuperDecorator decorator = new PuperDecorator();

    public void log() {
        try {
            saver.save(decorator.decorate());
        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
            throw new LogOperationException(e); //re-throw
        }
    }

    public void close() {
        throw new RuntimeException("close");
    }
}

class PuperSaver {
    public void save(String decoratedMessage) {
        if (decoratedMessage == null)
            throw new IllegalArgumentException("decMess must not be null!");
    }
}

class PuperDecorator {
    public String decorate() {
        return null;
    }
}

class LogOperationException extends RuntimeException {
    public LogOperationException(Throwable cause) {
        super(cause);
    }
}