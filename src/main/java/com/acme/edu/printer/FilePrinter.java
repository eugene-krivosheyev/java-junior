package com.acme.edu.printer;

import java.io.*;

/**
 * Created by Павел on 06.11.2015.
 */
public class FilePrinter implements Printable {

    //region fields
    private int buffer = 0;
    private static final int SIZE_BUFFER = 0;
    private static final String SEP = System.lineSeparator();
    private StringBuilder stringBuilder = new StringBuilder();
    private PrintWriter printWriter;
    //endregion

    //region constructor
    public FilePrinter(String fileName, String encoding) throws PrinterException {
        try {
            this.printWriter = new PrintWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(fileName, true), encoding));
        } catch (FileNotFoundException e) {
            throw new PrinterException("file not found", e);
        } catch (UnsupportedEncodingException e) {
            throw new PrinterException("Unsupported encoding", e);
        }
    }
    //endregion

    @Override
    public void print(String message) throws PrinterException {
        if (buffer < SIZE_BUFFER) {
            stringBuilder.append(message + SEP);
            buffer++;
        } else {
            printWriter.write(stringBuilder.toString());
            stringBuilder.setLength(0);
            buffer = 0;
        }
    }
}
