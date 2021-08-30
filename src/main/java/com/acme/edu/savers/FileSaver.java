package com.acme.edu.savers;
import com.acme.edu.exceptions.FileSaverException;

import java.io.*;

public class FileSaver extends AbstractSaver {
    @Override
    public void save(String message) throws FileSaverException {
        try (FileWriter writer = new FileWriter("results.txt", true)) {
            System.out.println("Niggas");
            writer.write(message + System.lineSeparator());
        }
        catch (IOException e) {
            throw new FileSaverException("error with file", e);
        }
    }
}
