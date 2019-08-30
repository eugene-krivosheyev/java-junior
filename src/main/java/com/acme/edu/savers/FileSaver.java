package com.acme.edu.savers;

import java.io.*;

public class FileSaver implements Saver {
    private String filename;

    public FileSaver(String filename) {
        this.filename = filename;
    }

    @Override
    public void save(String message) {
        try (PrintWriter out =
                     new PrintWriter(
                             new OutputStreamWriter(
                                     new BufferedOutputStream(
                                             new FileOutputStream(filename, true))))) {
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
