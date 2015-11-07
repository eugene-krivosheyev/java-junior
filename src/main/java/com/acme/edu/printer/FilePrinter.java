package com.acme.edu.printer;

import com.acme.edu.states.LoggerState;

import java.io.*;

/**
 * Created by Павел on 06.11.2015.
 */
public class FilePrinter implements Printable {

    //region fields
    private int buffer = 0;
    private static final int SIZE_BUFFER = 50;
    private PrintWriter printWriter;
    //endregion

    //region constructor
    public FilePrinter(String fileName, String encoding) throws PrinterException {
        try {
            this.printWriter = new PrintWriter(
                                    new BufferedWriter(
                                        new OutputStreamWriter(
                                            new FileOutputStream(fileName, true), encoding)));
        } catch (FileNotFoundException e) {
            throw new PrinterException("file not found", e);
        } catch (UnsupportedEncodingException e) {
            throw new PrinterException("Unsupported encoding", e);
        }
    }
    //endregion

    /**
     * The accumulation buffer and flush buffer.
     * Print to file.
     * @param message The <code>String</code> to be printed.
     * @throws PrinterException write to the file.
     */
    @Override
    public void print(String message) throws PrinterException {
        if (buffer < SIZE_BUFFER) {
            printWriter.write(message + LoggerState.SEP);
            buffer++;
        } else {
            printWriter.write(message + LoggerState.SEP);
            printWriter.flush();
            buffer = 0;
        }
    }

    /**
     * To close the stream writing to file
     */
    public void closeStream(){
        printWriter.close();
    }
}
