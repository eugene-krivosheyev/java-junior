package com.acme.edu.saver;

import java.util.Objects;

public class ConsoleSaver implements Saver {
    @Override
    public void save(String message) {
        if (!Objects.isNull(message)) {
            System.out.println(message);
        }
    }
}
