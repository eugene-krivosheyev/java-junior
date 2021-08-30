package com.db.edu.Save;

import java.io.IOException;

public class ConsoleSaver implements Saver {

    @Override
    public void save(String message) throws SaveException {
        try {
            System.out.println(message);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
