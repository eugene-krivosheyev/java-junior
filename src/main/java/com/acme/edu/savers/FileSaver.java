package com.acme.edu.savers;
import com.acme.edu.exceptions.FileSaverException;

import java.io.*;

public class FileSaver extends AbstractSaver {
    private String charsetCode = "Windows-1251";

    @Override
    public void save(String message) throws FileSaverException {
        try {
            File fileOutput = new File("results.txt");
            FileOutputStream outStream = new FileOutputStream(fileOutput, true);

            outStream.write(message.getBytes(charsetCode));
            outStream.write(System.lineSeparator().getBytes(charsetCode));
        }
        catch (FileNotFoundException e) {
            throw new FileSaverException("File not found", e);
        }
        catch (IOException e) {
            throw new FileSaverException("Error while writing in file", e);
        }
    }
}
