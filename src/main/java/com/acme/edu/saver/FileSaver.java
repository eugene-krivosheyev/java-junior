package com.acme.edu.saver;

import com.acme.edu.commands.Command;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileSaver implements Saver {

    private static final String fileName = "log.txt";

    @Override
    public void saveWithoutPrefix(Command command) throws SaverException {
        saveToFile(command.getMessage().toString());
    }

    @Override
    public void saveWithPrefix(Command command) throws SaverException {
        saveToFile(command.decorate());
    }

    private synchronized void saveToFile(String message) throws SaverException {
        try ( BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(new File(fileName), true))) {
            bufferedWriter.write(message + "\n");
        } catch (Exception e) {
            throw new SaverException(e);
        }
    }

}
