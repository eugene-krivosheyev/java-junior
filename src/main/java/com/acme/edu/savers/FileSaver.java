package com.acme.edu.savers;
import com.acme.edu.exceptions.FileSaverException;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

public class FileSaver extends AbstractSaver {
    private String charsetCode;
    private String fileName;

    public FileSaver(String fileName, String charsetCode) {
        this.fileName = fileName;
        this.charsetCode = charsetCode;

        // file creation
        Path path = Paths.get(fileName);
        try {
            Files.createFile(path);
        }
        catch (Exception e) {
            if (!path.toFile().exists()) {
                System.out.println("Can't create file");
            }
        }
    }

    @Override
    public void save(String message) throws FileSaverException {
        try {
            Path f = Paths.get("results.txt");
            Files.writeString(f, message + System.lineSeparator(), Charset.forName(charsetCode), APPEND);
        }
        catch (FileNotFoundException e) {
            throw new FileSaverException("File not found", e);
        }
        catch (IOException e) {
            throw new FileSaverException("Error while writing in file", e);
        }
    }
}
