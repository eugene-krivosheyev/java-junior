package com.acme.edu.save;

import com.acme.edu.command.Command;
import com.acme.edu.exceptions.SaveException;
import com.acme.edu.save.Saver;

import javax.security.sasl.SaslException;
import java.io.*;

public class FileSaverStateless implements Saver {

    private boolean append = true;

    String fileName;


    public FileSaverStateless(String s) {
        fileName = s;
    }

    public FileSaverStateless(String s, boolean append) {
        fileName = s;
        this.append = append;
    }

    @Override
    public void save(Command cmd) throws IOException, SaveException {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream(fileName,  append)))) {
            bufferedWriter.write(cmd.toString());
            bufferedWriter.newLine();
        } catch (FileNotFoundException e) {
            throw new SaveException("File not found");
        }
    }
}
