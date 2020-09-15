package com.acme.edu.saver;

import com.acme.edu.exception.SaverException;
import com.acme.edu.message.Message;

import java.io.*;

public class FileSaver implements Saver{

    File fileInfo;

    public FileSaver(String fileName){
        this.fileInfo = new File(fileName);
    }

    @Override
    public void save(Message toLog) throws SaverException {
        try (BufferedWriter bw =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new BufferedOutputStream(
                                             new FileOutputStream(fileInfo, true))))) {

            bw.write(toLog.toString() + "\n");
        } catch (IOException e) {
            throw new SaverException(e.getMessage());
        }
    }
}
