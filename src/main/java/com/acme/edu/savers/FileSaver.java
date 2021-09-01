package com.acme.edu.savers;
import com.acme.edu.exceptions.FileSaverException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSaver extends AbstractSaver {
    private final BufferedWriter out;

    public FileSaver(String fileName, String charsetCode, int buffSize) throws FileSaverException {
        createFileIfItDoesntExist(fileName);

        try {
            File file = new File(fileName);
            out = new BufferedWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    new FileOutputStream(file, true), buffSize), charsetCode));
        } catch (IOException e) {
            throw new FileSaverException("can't open file", e);
        }
    }

    private void createFileIfItDoesntExist(String fileName) throws FileSaverException {
        Path path = Paths.get(fileName);
        if (!path.toFile().exists()) {
            try {
                Files.createFile(path);
            }
            catch (IOException e) {
                throw new FileSaverException("can't create file", e);
            }
        }
    }

    @Override
    public void close() throws FileSaverException {
        try {
            out.close();
        } catch (IOException e) {
            throw new FileSaverException("can't close file", e);
        }
    }

    @Override
    public void save(String message) throws FileSaverException {
        try {
            out.write(message + System.lineSeparator());
        } catch (IOException e) {
            throw new FileSaverException("can't write in file", e);
        }
    }
}
