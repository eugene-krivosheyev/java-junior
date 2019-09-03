package com.acme.edu.savers;

import java.io.*;

/**
 * Created by kate-c on 03/09/2019.
 */
public class SimpleFileSaver implements Saver {
    private final String FILE_NAME = "file777.txt";
    private PrintWriter out = null;

    public SimpleFileSaver() {
        try {
            this.out = getNewOutStream();
            Runtime.getRuntime().addShutdownHook(new Thread (() -> {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(String message) {
        out.println(message);
        out.flush();

    }

    private PrintWriter getNewOutStream() throws FileNotFoundException {
        return new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(FILE_NAME, true))));
    }
}
