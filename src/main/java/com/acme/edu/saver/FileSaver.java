package com.acme.edu.saver;

import com.acme.edu.exception.SaveException;

import java.io.*;

public class FileSaver implements LoggerSaver {

    private final String fileInfo;

    public FileSaver(String fileInfo) {
        this.fileInfo = fileInfo;
    }

    @Override
    public void save(String representation) throws SaveException {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(
                         new OutputStreamWriter(
                            new BufferedOutputStream(
                                new FileOutputStream(fileInfo, true))))) {
            bufferedWriter.write(representation);
            bufferedWriter.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new SaveException("problems saving into file", e);
        }
    }
}
