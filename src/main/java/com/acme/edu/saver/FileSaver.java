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
        StringBuilder fileName = new StringBuilder("log.txt");
        int countLogFiles = 0;
        while (fileName.length() > 24) {
            countLogFiles++;
            fileName.append(countLogFiles);
        }
        try(FileWriter fileWriter = new FileWriter(fileName.toString(), true)) {
            fileWriter.append(message).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
