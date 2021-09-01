package com.db.edu.saver;

import com.db.edu.messagepack.message.Message;

import java.io.*;

public class FileSaver implements Saver{
    @Override
    public void save(Message message) throws SaveException {
        File log = new File("log.txt");

        try (BufferedWriter outputFile = new BufferedWriter(
                     new OutputStreamWriter(
                             new BufferedOutputStream(
                                     new FileOutputStream(log, true))))) {

            if (message == null) throw new IllegalArgumentException("FileSaver: Empty message is received");

            outputFile.write(message.getDecoratedMessage());
            outputFile.newLine();
        } catch (IOException e) {
            throw new SaveException("File saver: problem with saving", e);
        }
    }
}
