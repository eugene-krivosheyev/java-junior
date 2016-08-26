package demo;

import java.io.IOException;

public interface Saver {
    public static final int I = 0;
    void save(String message) throws IOException;

    default int getStatus() {
        this.hashCode();
        return 0;
    }

    static int gS() {
        return 0;
    }

    void close() throws IOException;
}
