package com.acme.edu.saver;

import java.io.*;

public class FileSaver implements Saver {
    private BufferedWriter writer;

    public FileSaver(String filePath) {
        try{
            writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    new FileOutputStream(filePath)), "windows-1251"));
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void save(String text) throws SaveException {
        if (text == null) {
            throw new SaveException("Message is null.");
        }

        try {
            writer.write(text);
            writer.flush();

        } catch (IOException e) {
            throw new SaveException("Error while saving message to file", e);
        }

    }
}
