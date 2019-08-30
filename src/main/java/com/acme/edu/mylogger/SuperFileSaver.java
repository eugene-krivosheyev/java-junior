package com.acme.edu.mylogger;

import java.io.*;
import java.nio.charset.Charset;

public class SuperFileSaver implements SuperSaver {
    private File file;

    /*
    public SuperFileSaver(File file) {
        this.file = file;
    }
    */

    @Override
    public void save(String message) throws IOException {
        final Charset win = Charset.forName("windows-1251");
        try (final PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream("logger.txt", true)), win))) {
            out.println(message);

        } catch (IOException e) {
            throw new IOException(e.getCause());
        }
    }
}
