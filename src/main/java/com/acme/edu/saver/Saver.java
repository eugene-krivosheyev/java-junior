package com.acme.edu.saver;

import java.io.IOException;

public interface Saver {
    public void save (String string) throws IOException;

    public void close();

}
