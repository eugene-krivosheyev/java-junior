package com.db.edu.saver;

import com.db.edu.LoggerException;

import java.io.*;

public class FileSaver implements Saver {
    private BufferedWriter writer;

    public FileSaver(File file, String format) {
        try {
            writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    new FileOutputStream(file)), format));
        }
        catch (FileNotFoundException ex) {
            throw new RuntimeException("File not found", ex);
        }
        catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Unsupported encoding exception", ex);
        }
    }

    @Override
    public void save(String s) throws LoggerException {
        try {
            writer.write(s);
            writer.newLine();
            writer.flush();
        } catch (IOException ex) {
            throw new LoggerException("Couldn't save message to file", ex);
        }
    }
}
