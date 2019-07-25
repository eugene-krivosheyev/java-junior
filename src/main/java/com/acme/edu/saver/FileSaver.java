package com.acme.edu.saver;

import java.io.*;

import static java.lang.System.lineSeparator;

public class FileSaver implements Saver {

    private File path = new File("Log_Info.txt");
    ;

    @Override
    public void save(String message) throws IOException {

        try (final BufferedWriter out
                     = new BufferedWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(
                                        path, true)), "UTF8"))) {

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
    public void delete() throws IOException {
        path.delete();
    }
}
