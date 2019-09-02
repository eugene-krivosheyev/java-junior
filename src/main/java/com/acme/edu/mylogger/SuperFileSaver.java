package com.acme.edu.mylogger;

import java.io.*;
import java.nio.charset.Charset;

public class SuperFileSaver implements SuperSaver {
    private File fileName;

    public SuperFileSaver(File fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(String message) throws IOException {
        try (final PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(this.fileName, true))))) {
            out.println(message);

        } catch (IOException e) {
            throw new IOException(e.getCause());
        }
    }
}
