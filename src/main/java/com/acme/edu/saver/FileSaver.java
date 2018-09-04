package com.acme.edu.saver;

import com.acme.edu.controller.LogOperationException;

import java.io.*;

/**
 * Created by Java_1 on 04.09.2018.
 */
public class FileSaver extends Saver {

    private String charsetName = "windows-1251";

    private static int MAX_SIZE = 10000000;

    @Override
    public  void save(String decoratedMessage) throws SaveException, LogOperationException {
        if (!super.checkIsNull(decoratedMessage)) {
            File file = new File(".", "logfile.txt");
            try (PrintWriter printWriter =
                         new PrintWriter(
                                 new OutputStreamWriter(
                                         new BufferedOutputStream(
                                                 new FileOutputStream(
                                                         file,
                                                         true)),
                                         charsetName))) {
                if (file.length() > MAX_SIZE) {
                    throw new IOException();
                }
                else{
                    printWriter.println(decoratedMessage);
                }
            } catch (IOException e) {
               throw new LogOperationException("Can't print to file", e, 666);
            }


        }
    }

    public void setMaxSize(int maxSize){
        this.MAX_SIZE = maxSize;
    }
}