package com.db.edu.save;

import com.db.edu.SaverException;
import java.io.*;

public class FileSaver implements Saver {
    private final String fileName;
    private final int buffSize;
    private final String charsetName;

    public FileSaver(String fileName, int buffSize, String charsetName) {
        this.fileName = fileName;
        this.buffSize = buffSize;
        this.charsetName = charsetName;
    }

    @Override
    public void save(String message) throws SaverException {
        File source = new File(fileName);
        try (BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(source), buffSize), charsetName))) {
            out.write(message + System.lineSeparator());

        } catch (IOException e) {
            throw new SaverException("Could not save message to file", e);
        }
    }
}