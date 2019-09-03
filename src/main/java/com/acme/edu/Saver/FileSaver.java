package com.acme.edu.Saver;

import java.io.*;

public class FileSaver implements SuperSaver {
    @Override
    public void save(String message) {
        try (final PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream("result.txt", true))))) {
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
