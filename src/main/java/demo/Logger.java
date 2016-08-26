package demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Logger {
    /**
     * Creational Patterns
     */
    private final Filter filter; //DI
    private final Saver saver = SaverFactory.create();
    private final Decorator decorator = null;

    public Logger(Filter filter) {
        this.filter = filter;
    }

    public Decorator log(String message) {
        if (filter.filter(message)) {
            try {
                saver.save(decorator.decorate(message));
                throw new RuntimeException("0");
                //...
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                //.........
                throw new RuntimeException("1", e);
            } finally {
                try {
                    saver.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("2");
            }
        }

        int i = 7;
        return mes -> mes + "!!!!" + i;
    }
}

class Client {
    public static void main(String[] args) {
        Logger logger = new Logger(new Filter() {
            @Override
            boolean filter(String message) {
                return true;
            }
        });
        logger.log("message");

    }
}




