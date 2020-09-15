package com.acme.edu.saver;

import com.acme.edu.command.LoggerCommand;
import com.acme.edu.exception.SaveException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileSaver implements LoggerSaver {
    private final String file = "targetFile.txt";

    @Override
    public void saveMessage(LoggerCommand message) throws SaveException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file)), StandardCharsets.UTF_8))) {
            bw.write(message.toString());
        } catch (FileNotFoundException e) {
            throw new SaveException("File " + file + " does not exist", e);
        } catch (IOException e) {
            throw new SaveException("Cannot save file", e);
        }
    }
}
