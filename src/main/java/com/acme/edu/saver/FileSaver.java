package com.acme.edu.saver;

import com.acme.edu.exception.SaverException;
import com.acme.edu.message.Message;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSaver implements Saver{

    String fileName;

    public FileSaver(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void save(Message toLog) throws SaverException {
        try (FileWriter out = new FileWriter(fileName, true)) {
            out.append(toLog.toString() + "\n");
        } catch (FileNotFoundException e) {
            throw new SaverException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
