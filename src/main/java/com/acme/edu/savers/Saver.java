package com.acme.edu.savers;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by kate-c on 23/08/2019.
 */
public interface Saver extends Closeable {
    void save(String message);
    void close() throws IOException;
}
