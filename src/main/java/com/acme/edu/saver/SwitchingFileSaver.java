package com.acme.edu.saver;

import java.io.IOException;

public class SwitchingFileSaver extends FileSaver {
    private final int limit;
    private int recordsCounter = 0;
    private int fileCounter = 0;
    private String name;
    private String format;

    public SwitchingFileSaver(String name, String format, int limit, boolean append) throws IOException {
        super(name + format, append);
        this.limit = limit;
        this.name = name;
        this.format = format;
    }

    @Override
    public synchronized void save(String string) throws IOException {
        recordsCounter++;

        if (recordsCounter > limit) {
            recordsCounter = 0;
            switchFile();
        }

        super.save(string);
    }

    private void switchFile() throws IOException {
        super.close();
        fileCounter++;
        super.filename = name + Integer.toString(fileCounter) + format;
        super.open();
    }
}
