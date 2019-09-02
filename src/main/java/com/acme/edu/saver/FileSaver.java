package com.acme.edu.saver;

import com.acme.edu.commands.Command;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver implements Saver {

    private static final String fileName = "log.txt";

    @Override
    public void saveWithoutPrefix(Command command) throws SaverException {
        saveToFile((String) command.getMessage());
    }

    @Override
    public void saveWithPrefix(Command command) throws SaverException {
        saveToFile(command.decorate());
    }

    private void saveToFile(String message) throws SaverException {
        try(FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.append(message).append("\n");
        } catch (IOException e) {
            throw new SaverException(e);
        }
    }

}
