package com.acme.edu.saver;

import com.acme.edu.loggerexceptions.LoggerErrors;
import com.acme.edu.loggerexceptions.LoggerSaverException;

import java.io.*;
import java.nio.file.Paths;

public class FileLoggerSaver implements Saver {
    public static final String LOG_FILES_DIRECTORY = Paths.get(".", "logs").toString();
    private static final String PREFIX_PATH = Paths.get(LOG_FILES_DIRECTORY, "log_").toString();

    private File fileToSaveInto;
    private String encoding;
    private int logFileSizeInBytes = 50 * 1024 * 1024;

    public String getLogFilename() {
        return fileToSaveInto.getAbsolutePath();
    }

    public FileLoggerSaver(String encoding) throws LoggerSaverException {
        this.encoding = encoding;

        File logDirectory = new File(LOG_FILES_DIRECTORY);
        if (!logDirectory.exists()) {
            logDirectory.mkdir();
        }
        createLogFile();
    }

    @Override
    public void save(String decoratedOutput) throws LoggerSaverException {
        if (fileToSaveInto.length() > logFileSizeInBytes) {
            createLogFile();
        }
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(fileToSaveInto, true)
                )
        )) {
            printWriter.println(decoratedOutput);
        } catch (FileNotFoundException e) {
            throw new LoggerSaverException("could not write into file", LoggerErrors.UNABLE_SAVE_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isNull(String decoratedOutput) {
        return isNull(decoratedOutput);
    }

    public int getLogFileSizeInBytes() {
        return logFileSizeInBytes;
    }

    public void setLogFileSizeInBytes(int logFileSizeInBytes) {
        this.logFileSizeInBytes = logFileSizeInBytes;
    }

    private void createLogFile() throws LoggerSaverException {
        long timestamp = System.currentTimeMillis();
        fileToSaveInto = new File(PREFIX_PATH + timestamp);

        if (!fileToSaveInto.exists()) {
            try {
                fileToSaveInto.createNewFile();
            } catch (IOException e) {
                throw new LoggerSaverException("could not create new empty file",
                        LoggerErrors.UNABLE_SAVE_FILE);
            }
        }
        fileToSaveInto.length();
    }
}
