package com.acme.edu.savers;

import java.io.*;

/**
 * Created by kate-c on 30/08/2019.
 */
public class FileSaver implements Saver {
    private final int MAX_NUMBER_OF_FLUSHES;
    private final String fileNameBase = "file";
    private final String fileExtension = ".txt";

    private int currentNumberOfFlushes;
    private int currentFileNameIndex;

    public FileSaver(int MAX_NUMBER_OF_FLUSHES) {
        this.MAX_NUMBER_OF_FLUSHES = MAX_NUMBER_OF_FLUSHES;
        currentFileNameIndex = getCurrentFileNameIndex();
    }

    @Override
    public void save(String message) {
        if (currentNumberOfFlushes == MAX_NUMBER_OF_FLUSHES) {
            currentNumberOfFlushes = 0;
            currentFileNameIndex++;
        }
        try (final PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(getFileName(), true))))) {

            out.println(message);
            currentNumberOfFlushes++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileName() {
        return fileNameBase + currentFileNameIndex + fileExtension;
    }
    private String getFileName(int index) {
        return fileNameBase + index + fileExtension;
    }

    private int getCurrentFileNameIndex() {
        int index = 0;
        File f = new File(getFileName(index));
        if (!f.exists()) {
            return index;
        }

        do {
            f = new File(getFileName(++index));
        }
        while (f.exists());

        return index;
    }
}
