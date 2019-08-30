package com.acme.edu.savers;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSaver implements Saver {
    private Path filePath;

    public FileSaver(String filename) {
        this.filePath = Paths.get(filename);
    }

    @Override
    public void save(String message) {
        try (PrintWriter out =
                     new PrintWriter(
                             new OutputStreamWriter(
                                     new BufferedOutputStream(
                                             new FileOutputStream(this.filePath.toString(), true))))) {
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
