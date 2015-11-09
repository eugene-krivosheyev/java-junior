package com.acme.edu.printer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Павел on 06.11.2015.
 */
public class FilePrinter extends PrinterManager {

    //for me: реюз общие методы и поля в абстрактный класс. Для классов FilePrinter и RemotePrinter!!!

    //region fields
    private String fileName;
    private String encoding;
    private List<String> bufferMessages = new ArrayList<>(SIZE_BUFFER);
    //endregion

    //region constructor

    /**
     * Initialize the stream to write
     *
     * @param fileName the name of the file to which to write
     * @param encoding encoding to write data
     * @throws PrinterException check the character set and the file exists
     */
    public FilePrinter(String fileName, String encoding) throws PrinterException {
        this.fileName = fileName;
        this.encoding = encoding;
    }
    //endregion

    /**
     * The accumulation buffer and flush buffer.
     * Print to file.
     *
     * @param message The <code>String</code> to be printed.
     * @throws PrinterException write to the file.
     */
    @Override
    public void print(String message) throws PrinterException {
        bufferMessages.add(message + SEP);
        if (checkBuffer(bufferMessages)) {
            sortBuffer(bufferMessages);
            writeToFile();
        }
    }

    private void writeToFile() throws PrinterException {
        try (BufferedWriter printWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), encoding))){
            printWriter.write(bufferMessages.toString());
            printWriter.flush();
            bufferMessages.clear();
        } catch (Exception e) {
            throw new PrinterException(e);
        }
    }
}
