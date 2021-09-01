package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.*;
import java.util.List;

import static java.nio.file.Files.lines;
import static java.nio.file.StandardOpenOption.*;

public class IoDemo {
    public static void main(String[] args) {
        //region must have
        File fileInfo1 = new File("file.txt");
        Path fileInfo2 = Paths.get("file2.txt");
        fileInfo2.toFile();

        /*
        try (RandomAccessFile raf = new RandomAccessFile(fileInfo1.getAbsolutePath(), "rw")) {
            raf.readUTF();
            raf.seek(1_000);
        } catch (IOException e) {
            e.printStackTrace();
        }
         */


        try {
            Files.writeString(fileInfo2, "12341 ", CREATE, WRITE, APPEND);
            Files.writeString(fileInfo2, "12342 ", CREATE, WRITE, APPEND);
            Files.writeString(fileInfo2, "12343 ", CREATE, WRITE, APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<String> lines = Files.readAllLines(fileInfo2);
            lines.forEach(System.out::println);

            lines(fileInfo2).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //endregion

        //region Blocking I/O

        //endregion
    }
}
