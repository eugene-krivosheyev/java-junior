package demo;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public class ConsoleSaver extends Object implements Saver, Serializable {
    @Override
    public void save(String message) throws IOException {
        if (message == null) throw new IOException();
        System.out.println(message);
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public void close() throws IOException {
        System.out.println("close()");
    }
}
