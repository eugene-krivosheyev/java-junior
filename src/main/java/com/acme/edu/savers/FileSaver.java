package com.acme.edu.savers;

import com.acme.edu.exceptions.SaverException;

import java.io.*;

public class FileSaver implements Saver {
    private final int maxCharactersNumber;
    private String filename;
    private String filetype;
    private int currentCharactersNumber;
    private int fileNumberCounter;
    private String filePath;

    public FileSaver(String filename, String filetype, int maxCharactersNumber){
        this.filename = filename;
        this.filetype = filetype;
        this.filePath = filename + "." + filetype;
        this.maxCharactersNumber = maxCharactersNumber;
        this.currentCharactersNumber = 0;
        this.fileNumberCounter = 1;
    }

    @Override
    public void save(String message) throws SaverException {
        currentCharactersNumber += message.length();
        if(currentCharactersNumber > maxCharactersNumber){
            filePath = filename + fileNumberCounter + "." + filetype;
            fileNumberCounter++;
            currentCharactersNumber = 0;
        }
        try (final PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(filePath, true))))) {
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
            throw new SaverException("Error happened while FileSaver operations", e);
        }
    }
}
