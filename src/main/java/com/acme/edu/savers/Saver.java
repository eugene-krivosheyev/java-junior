package com.acme.edu.savers;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by kate-c on 23/08/2019.
 */
public interface Saver {
    void save(String message);
}
