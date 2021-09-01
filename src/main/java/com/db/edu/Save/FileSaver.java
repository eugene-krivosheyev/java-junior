package com.db.edu.Save;

import java.io.*;
import java.nio.charset.Charset;

public class FileSaver implements Saver {
    @Override
    public void save(String message) throws SaveException {
        File outputFile = new File("log.txt");
        int size = 8192;
        Charset charSet = Charset.defaultCharset();
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
