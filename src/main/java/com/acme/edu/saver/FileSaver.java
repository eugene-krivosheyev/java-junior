package com.acme.edu.saver;

import com.acme.edu.command.LoggerCommand;
import com.acme.edu.exception.SaveException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileSaver implements LoggerSaver {
    private final String fileName;

    public FileSaver(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void saveMessage(LoggerCommand message) throws SaveException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(fileName, true))))) {
            bw.write(message.toString());
            bw.newLine();
        } catch (FileNotFoundException | NullPointerException e) {
            throw new SaveException("file " + fileName + " does not exist", e);
        } catch (IOException e) {
            throw new SaveException("cannot save file", e);
        }
    }
}
