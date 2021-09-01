package com.acme.edu.ooad.saver;

import com.acme.edu.ooad.exception.SaveException;
import com.acme.edu.ooad.message.Message;

import java.io.*;

public class FileSaver extends ValidatingSaver {
    private String encoding;
    private int bufferSize;
    private String filePath;
    private boolean isAppended;

    public FileSaver(String encoding, int bufferSize, String filePath, boolean isAppended) {
        this.encoding = encoding;
        this.bufferSize = bufferSize;
        this.filePath = filePath;
        this.isAppended = isAppended;
    }

    @Override
    public void save(Message message) throws SaveException {
        try (BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(filePath,isAppended),bufferSize),encoding))) {
            super.save(message);
            out.write(message.toString() + System.lineSeparator());
        } catch (IOException e) {
            throw new SaveException(e);
        }
    }
}
