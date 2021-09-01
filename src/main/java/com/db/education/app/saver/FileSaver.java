package com.db.education.app.saver;

import com.db.education.app.exception.SaveException;
import com.db.education.app.message.Message;

import java.io.*;

public class FileSaver implements Saver{
    private final String fileName;
    private final int bufferSize;
    private final String charSet;

    public FileSaver(String fileName, int bufferSize, String charSet) {
        this.fileName = fileName;
        this.bufferSize = bufferSize;
        this.charSet = charSet;
    }

    @Override
    public void save(Message message) throws SaveException {
        try {
            if (message == null) throw new NullPointerException();
        } catch (NullPointerException npe) {
            throw new SaveException("Empty message: " + npe.getMessage(), npe);
        }

        try (BufferedWriter fileWriter = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(fileName, true), charSet), bufferSize)) {
            fileWriter.write(message.toString());
        } catch (FileNotFoundException fnfe) {
            throw new SaveException("Log to file " + this.fileName + " failed", fnfe);
        } catch (IOException ioe) {
            throw new SaveException("Log to file " + this.fileName + " failed", ioe);
        }
    }
}
