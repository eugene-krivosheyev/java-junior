package twrdemo;

import java.io.Closeable;
import java.io.IOException;

public class TWRDemo {
    public static void main(String[] args) {
        try (Appender appender = new Appender();) {
            appender.append(); //BL
        } catch (RuntimeException e) {
            throw new RuntimeException("2", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Appender implements Closeable {
    @Override
    public void close() throws IOException {
        throw new RuntimeException("3");
    }

    public void append() {
        throw new RuntimeException("1");
    }
}