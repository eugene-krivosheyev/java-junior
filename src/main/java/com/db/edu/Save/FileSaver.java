package com.db.edu.Save;

import java.io.*;
import java.nio.charset.Charset;

public class FileSaver implements Saver {
    int size;
    Charset charSet;
    File outputFile;

    public FileSaver() {
        this.size = 8192;
        this.charSet = Charset.defaultCharset();
        this.outputFile = new File("log.txt");
    }

    public FileSaver(int size, Charset charSet, File outputFile) {
        this.size = size;
        this.charSet = charSet;
        this.outputFile = outputFile;
    }

    public FileSaver(File outputFile) {
        this.outputFile = outputFile;
    }

    @Override
    public void save(String message) throws SaveException {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(outputFile), size), charSet))) {
            out.write(message);
            System.out.println("log save to file");
        } catch (FileNotFoundException e) {
            throw new SaveException("File not found", e);
        } catch (IOException e) {
            throw new SaveException("Input/output error", e);
        }
    }
}
