package com.acme.edu.saver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class FileSaver implements Saver{
    private String path;

    public FileSaver(String path) {
        this.path = path;
    }

    @Override
    public void save(String message) {
        if (!Objects.isNull(message)) {
            try (final BufferedWriter out = new BufferedWriter(new FileWriter(path, true))) {
                out.write(message + System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
