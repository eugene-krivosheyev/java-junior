package com.acme.edu.saver;

import com.acme.edu.LogException;

import java.io.*;

/**
 * Created by Java_12 on 04.09.2018.
 */
public class FileSaver extends ParameterCheckingSaver {
    private PrintWriter printWriter;

    public FileSaver(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    @Override
    public void save(String decoratedString) throws LogException {
        super.save(decoratedString);
        printWriter.println(decoratedString);
        printWriter.flush();
    }
}
