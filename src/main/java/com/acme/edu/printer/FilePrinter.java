package com.acme.edu.printer;

import java.io.*;

/**
 * Created by Павел on 06.11.2015.
 */
public class FilePrinter implements Printable {

    //region fields
    private int buffer = 0;
    private StringBuilder stringBuilder = new StringBuilder();
    private OutputStreamWriter printWriter;
    //endregion

    //region constructor

    /**
     * Initialize the stream to write
     * @param fileName the name of the file to which to write
     * @param encoding encoding to write data
     * @throws PrinterException check the character set and the file exists
     */
    public FilePrinter(String fileName, String encoding) throws PrinterException {
        try {
            this.printWriter = new OutputStreamWriter(new FileOutputStream(fileName, true), encoding);
        } catch (FileNotFoundException e) {
            printerException.listExciption.add(e);
            throw printerException;
        } catch (UnsupportedEncodingException e) {
            printerException.listExciption.add(e);
            throw printerException;
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
        stringBuilder.append(message + SEP);
        if (buffer < SIZE_BUFFER) {
            buffer++;
        } else {
            try {
                printWriter.write(stringBuilder.toString());
                printWriter.flush();
                stringBuilder.setLength(0);
                buffer = 0;
            }catch (IOException e){
                printerException.listExciption.add(e);
                throw printerException;
            }
        }
    }
}
