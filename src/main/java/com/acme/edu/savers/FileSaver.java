package com.acme.edu.savers;
import java.io.*;

public class FileSaver extends AbstractSaver {
    @Override
    public void save(String message) {
        try (FileWriter writer = new FileWriter("results.txt", true)) {
            writer.write(message + System.lineSeparator());
        }
        catch (IOException err) {
            System.out.println("exception: " + err.getMessage());
        }
    }
}
