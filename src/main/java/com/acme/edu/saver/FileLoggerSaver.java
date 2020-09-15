package com.acme.edu.saver;

import com.acme.edu.exceptions.FileLoggerSaverException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileLoggerSaver implements LoggerSaver{

    @Override
    public void save(String message) throws FileLoggerSaverException {
        if(message == null) {throw new FileLoggerSaverException("Empty message!")};

        try (BufferedWriter bw =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new BufferedOutputStream(
                                             new FileOutputStream("test.txt")), StandardCharsets.UTF_8))){
            bw.write(message);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
