package com.db.education.app.saver;

import com.db.education.app.exception.SaveException;
import com.db.education.app.message.EmptyMessage;
import com.db.education.app.message.Message;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileSaver implements Saver{
    private final String fileName;
    private final int bufferSize;
    private final String charSet;

    public FileSaver(String fileName, int bufferSize, String charSet) {
        this.fileName = fileName;
        this.bufferSize = bufferSize;
        this.charSet = charSet;
    }

    @Override
    public void save(Message message) throws SaveException {
        try (FileWriter fileWriter = new FileWriter(fileName, Charset.forName(charSet), true)){
            if(message == null) throw new NullPointerException();

            fileWriter.write(message.toString());
        } catch (NullPointerException npe) {
            throw new SaveException("Empty message: " + npe.getMessage(), npe);
        }catch (IOException e) {
            throw new SaveException("Log to file " + this.fileName + " failed", e);
        }
    }
}
