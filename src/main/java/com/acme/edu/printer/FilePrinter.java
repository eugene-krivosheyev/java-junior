package com.acme.edu.printer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Павел on 06.11.2015.
 */
public class FilePrinter implements Printable {

    //for me: реюз общие методы и поля в абстрактный класс. Для классов FilePrinter и RemotePrinter!!!

    //region fields
    private int buffer = 0;
    private List<String> bufferMessages = new ArrayList<>(SIZE_BUFFER);
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
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            printerException.listExciption.add(e);
            throw printerException;
        }catch (NullPointerException e){
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
        bufferMessages.add(message + SEP);
        if (buffer < SIZE_BUFFER) {
            buffer++;
        } else {
            try {
                printWriter.write(bufferMessages.toString());
                printWriter.flush();
                bufferMessages.clear();
                buffer = 0;
            }catch (IOException e){
                printerException.listExciption.add(e);
                throw printerException;
            }
        }
    }
}
