package com.acme.edu.saver;

import com.acme.edu.exception.SaveException;
import com.acme.edu.message.AbstractMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.System.lineSeparator;

/**
 * Implementation of Saver interface for saving log messages to file.
 * @see Saver
 */
public class FileSaver implements Saver {
    private final String path;
    private BufferedWriter writer;

    public FileSaver(String path) {
        this.path = path;
    }

    @Override
    public void save(AbstractMessage message) throws SaveException {
        try {
            if (this.writer == null) {
                this.writer = new BufferedWriter(new FileWriter(path));
            }
        } catch (IOException e) {
            throw new SaveException("Cannot create such file!", e);
        }

        try {
            this.writer.append(message.getPreparedMessage()).append(lineSeparator());
        } catch (IOException e) {
            throw new SaveException("Cannot write to this file!", e);
        }
    }

    public void closeWriter() throws SaveException {
        try {
            writer.close();
        } catch (IOException e) {
            throw new SaveException("File cannot be closed!", e);
        }
    }
}
