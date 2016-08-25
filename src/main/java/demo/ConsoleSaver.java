package demo;

import java.io.Serializable;
import java.util.Objects;

public class ConsoleSaver extends Object implements Saver, Serializable {
    @Override
    public void save(String message) {

    }

    @Override
    public int getStatus() {
        return 0;
    }
}
