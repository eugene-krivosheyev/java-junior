package com.acme.edu.saver;

import com.acme.edu.commands.Command;

import java.io.FileWriter;
import java.io.IOException;

public class FileSaver implements Saver {

    @Override
    public void saveWithoutPrefix(Command command) {
        saveToFile((String) command.getMessage());
    }

    @Override
    public void saveWithPrefix(Command command) {
        saveToFile(command.decorate());
    }

    private void saveToFile(String message) {
        String fileName = "log.txt";
        try(FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.append(message).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
