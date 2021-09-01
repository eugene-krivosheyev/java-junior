package com.db.edu.save;

import com.db.edu.SaverException;
import java.io.*;

public class FileSaver implements Saver {
    private final String fileName = "data.txt";

    @Override
    public void save(String message) throws SaverException {
        File source = new File(fileName);
        try (BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(source))))) {
            out.write(message + System.lineSeparator());

        } catch (IOException e) {
            throw new SaverException("Could not save message to file", e);
        }
    }
}
