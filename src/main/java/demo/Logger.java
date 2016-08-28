package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    public Decorator log(String message) throws FilterException {
        if (filter.filter(message)) {
/*
            try (Saver saver2 = saver) {
//            try (Saver saver = new ConsoleSaver()) {
                saver2.save(decorator.decorate(message));
                throw new RuntimeException("0");
                //...
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                //.........
                throw new RuntimeException("1", e);
            } finally {
//                saver2.getStatus();
            }
*/
        }
        try (
            Saver s = new ConsoleSaver()
        ) {
            throw new IOException("1111");
        } catch (IOException e) {
            throw new RuntimeException("222", e);
        } finally {
            throw new RuntimeException("333");
        }

        /*
        int i = 7;
        return mes -> mes + "!!!!" + i;
        */
    }
}

class Client {
    public static void main(String[] args) throws FilterException {
        Logger logger = new Logger(new Filter() {
            @Override
            boolean filter(String message) {
                return true;
            }
        });
        logger.log("message");

    }
}




