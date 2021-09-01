package com.db.edu.Save;

public class ConsoleSaver implements Saver {

    @Override
    public void save(String message) throws SaveException {
        try {
            System.out.println(message);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new SaveException(e);
        }
    }
}
