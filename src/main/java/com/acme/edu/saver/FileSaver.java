package com.acme.edu.saver;

import java.io.*;

import static java.lang.System.lineSeparator;

public class FileSaver implements Saver {

    private File path = new File("Log_Info.txt");
    private final BufferedWriter out;

    FileSaver() throws IOException {
        try {
            out = new BufferedWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    new FileOutputStream(
                                            path, true)), "UTF8"));

        } catch (IOException e) {
            throw new IOException("Failed to save in file!", e);
        }
    }

    @Override
    public void save(String message) throws IOException {
            try {
                out.write(message);
            } catch (IOException e) {
                throw new IOException("Failed to save in file!", e);
            }
    }

    @Override
    public void newLog() throws IOException {
        save("*^*^*^*^*^*^*^*^*^*^*^*" + lineSeparator());
    }

    @Override
    public void close() throws IOException {
        out.close();
    }

    @Override
    public void delete() throws IOException {
        path.delete();
    }
}
