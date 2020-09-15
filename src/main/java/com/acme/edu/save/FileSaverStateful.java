package com.acme.edu.save;

import com.acme.edu.command.Command;

import java.io.*;

public class FileSaverStateful implements Saver{
    private final BufferedWriter bufferedWriter;

    String fileName;

    boolean append = true;

    public FileSaverStateful(String s) throws FileNotFoundException {
        fileName = s;
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName,  append)));

    }

    public  FileSaverStateful(String s, boolean a) throws FileNotFoundException {
        fileName = s;
        append = a;
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName,  append)));
    }

    @Override
    public void save(Command cmd) throws IOException {
        bufferedWriter.write(cmd.toString());
        bufferedWriter.newLine();
    }
}
