package com.acme.edu.saver;

import com.acme.edu.commands.Command;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileSaver implements Saver {

    private static final String fileName = "log.txt";

    @Override
    public synchronized void saveWithoutPrefix(Command command) throws SaverException {
        saveToFile(command.getMessage().toString());
    }

    @Override
    public synchronized void saveWithPrefix(Command command) throws SaverException {
        saveToFile(command.decorate());
    }

    private synchronized void saveToFile(String message) throws SaverException {
        try {
            File file = new File(fileName);
            FileWriter fileReader = new FileWriter(file, true); // поток который подключается к текстовому файлу
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader); // соединяем FileWriter с BufferedWriter

            bufferedWriter.write(message + "\n");

            bufferedWriter.close(); // закрываем поток
        } catch (Exception e) {
            throw new SaverException(e);
        }
    }

}
