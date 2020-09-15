package com.acme.edu.saver;

import com.acme.edu.exceptions.FileLoggerSaverException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileLoggerSaver implements LoggerSaver{
    private final File fileInfo;

    public FileLoggerSaver(String fileInfo) {
        this.fileInfo = new File(fileInfo);
    }

    @Override
    public void save(String message) throws FileLoggerSaverException {
        if(message == null) throw new FileLoggerSaverException("Empty message!");

        try (BufferedWriter bw =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new BufferedOutputStream(
                                             new FileOutputStream(fileInfo)), StandardCharsets.UTF_8))){
            bw.write(message);

        } catch(IOException e) {
            e.printStackTrace();
            throw new FileLoggerSaverException("Can't open File",e);
        }
    }
}
