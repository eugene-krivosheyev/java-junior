package demo.ooad.saver;

import demo.ooad.LoggerMessage;

public class FileLoggerSaver implements LoggerSaver {
    private String filename;

    public FileLoggerSaver(String filename) {
        this.filename = filename;
    }

    @Override
    public void save(LoggerMessage message) {

    }
}
