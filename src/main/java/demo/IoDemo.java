package demo;

import java.io.*;
import java.nio.file.*;
import java.util.List;

import static java.nio.file.Files.lines;
import static java.nio.file.StandardOpenOption.*;

public class IoDemo {
    public static void main(String[] args) {
        //region must have
        /*
        File fileInfo1 = new File("file.txt");
        Path fileInfo2 = Paths.get("file2.txt");
        fileInfo2.toFile();


        try (RandomAccessFile raf = new RandomAccessFile(fileInfo1.getAbsolutePath(), "rw")) {
            raf.writeDouble(1.0);
            raf.writeByte(1);
            raf.readUTF();
            raf.seek(1_000);
        } catch (IOException e) {
            e.printStackTrace();
        }



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
        */
        //endregion

        //region (Classic) Blocking I/O API
        // Legacy -> many libs
        // DP: Decorator
        // Simpler then NIO -> network app -> distributed systems design

        File source = new File("data.txt");
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(source)),"windows-1251"))) {

            String readLine;
            while((readLine = in.readLine()) != null) {
                System.out.println(readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        /*
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String readLine;
            while((readLine = reader.readLine()) != null) {
                System.out.println(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        //endregion

        //region NIO2
        // + Async/non-blocking
        // + Native
        //endregion
    }
}
