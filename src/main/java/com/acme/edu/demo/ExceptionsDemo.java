package com.acme.edu.demo;

import java.io.*;

public class ExceptionsDemo {
    public static void main(String[] args) {
        try (
                final Controller controller = new Controller();
                final FileOutputStream fileInputStream = new FileOutputStream("a.txt")
        ) {

            controller.log();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Controller implements AutoCloseable  {
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

    @Override
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