package demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.Files.writeString;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.WRITE;

public class IODemo {
    public static void main(String[] args) {
//        File/Path

//        try {
//            final File file = new File("a.txt");
//            file.createNewFile();
//
//            writeString(file.toPath(), "HW!!!", WRITE, APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {

            Files.lines(get("a.txt")) //readAllLines
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
