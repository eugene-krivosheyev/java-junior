package com.db.edu.save;

public class ConsoleSaver implements Saver {

    public void save(String message) {
        System.out.println(message);
    }
}
