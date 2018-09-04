package com.acme.edu.saver;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileSaver implements Saver {
    private String fileName;
    private boolean toAppend;
    private String charsetName;
    private String parent;

    public FileSaver() {
        this(".", "default.txt", false, "UTF-16");
    }

    public FileSaver(String parent, String fileName, boolean toAppend, String charsetName) {
        this.parent = parent;
        this.fileName = fileName;
        this.toAppend = toAppend;
        this.charsetName = charsetName;
    }

    @Override
    public void output(String message) throws SavingException {
        File file = new File(parent, fileName);
        try (PrintWriter printWriter =
                     new PrintWriter(
                             new OutputStreamWriter(
                                     new BufferedOutputStream(
                                             new FileOutputStream(
                                                     file,
                                                     toAppend)),
                                     charsetName))) {
            toAppend = true;
            printWriter.println(message);
        } catch (IOException e) {
            throw new SavingException("Could not open file or write to it", e, 2);
        }
    }
}
