package com.acme.edu.mylogger;

import java.io.*;
import java.nio.charset.Charset;

public class SuperFileSaver implements SuperSaver {
    private String fileName;

    public SuperFileSaver(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(String message) throws IOException {
        final Charset win = Charset.forName("windows-1251");
        try (final PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(this.fileName, true)), win))) {
            out.println(message);

        } catch (IOException e) {
            throw new IOException(e.getCause());
        }
    }
}
