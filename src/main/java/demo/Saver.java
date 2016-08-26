package demo;

import java.io.Closeable;
import java.io.IOException;

public interface Saver extends Closeable {
    public static final int I = 0;
    void save(String message) throws IOException;

    default int getStatus() {
        this.hashCode();
        return 0;
    }

    static int gS() {
        return 0;
    }
}
