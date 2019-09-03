package com.acme.edu.savers;

import java.io.*;

/**
 * Created by kate-c on 30/08/2019.
 */
public class FileSaver implements Saver {
    private final int MAX_NUMBER_OF_FLUSHES;
    private final String fileNameBase = "file";
    private final String fileExtension = ".txt";

    private PrintWriter out = null;

    private int currentNumberOfFlushes;
    private int currentFileNameIndex;

    public FileSaver(int MAX_NUMBER_OF_FLUSHES) {
        this.MAX_NUMBER_OF_FLUSHES = MAX_NUMBER_OF_FLUSHES;
        currentFileNameIndex = getCurrentFileNameIndex();
    }

    @Override
    public void save(String message) {
        if (out == null) {
            try {
                out = getNewOutStream();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        out.println(message);
        currentNumberOfFlushes++;

        if (currentNumberOfFlushes == MAX_NUMBER_OF_FLUSHES) {
            currentNumberOfFlushes = 0;
            currentFileNameIndex++;
            out = null;
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

    private PrintWriter getNewOutStream() throws FileNotFoundException {
        return new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(getFileName(), true))));
    }

//    @Override
//    public void close() throws IOException {
//        out.flush();
//        out.close();
//        out = null;
//    }
}
