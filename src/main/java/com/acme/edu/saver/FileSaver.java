package com.acme.edu.saver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSaver implements Saver {

    protected String filename = "";

    protected PrintWriter out;
    protected boolean isClosed = false;

    public FileSaver (String filename, boolean append) throws IOException {
        if(!append) {
            try {
                Files.deleteIfExists(Paths.get(filename));
            } catch (IOException ignored) { }
        }
        this.filename = filename;

        open();
    }


    protected void open() throws  IOException{
        out = new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(filename, true))));

    }

    @Override
    public synchronized void save(String string) throws IOException{
        out.println(string);
        out.flush();
    }

    public synchronized void close() {
        if (isClosed) return;

        isClosed = true;

        out.flush();
        out.close();
    }
}
