package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.io.File.pathSeparator;
import static java.io.File.separator;
import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;

public class IODemo {
    /**
     * No NIO2, just plain old blocking IO demo.
     */
    public static void main(String[] args) throws IOException {
        //region FileInfo
        /*
        java.io.File pathInfo = new File(".", "test.txt");
        System.out.println(pathSeparator + " and " + separator);
        pathInfo.list((dir, name) -> !name.contains(".sys"));
        */
        //endregion

        //region RAF
        /*
        try (RandomAccessFile randomAccessFile
                = new RandomAccessFile(pathInfo, "rw")) {

            randomAccessFile.seek(0L);
            randomAccessFile.read();

        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        //endregion

        //region Char IO
        /*
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(
                        new File(".", "test_unicode.txt")
                )
        )) {

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(">>>" + line);
            }

        }
        */
        //endregion

        //region Byte output
        File file = new File(".", "test.txt");
        try (PrintWriter printWriter =
            new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(
                                        file,
                                        false)),
                        "windows-1251"))) {

            printWriter.println("тестовая строка 1");
            printWriter.println("тестовая строка 2");

        } catch (IOException e) {
            e.printStackTrace();
        }
        //endregion

        //region Byte input
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(file)),
                        "windows-1251"))) {

            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                System.out.println(":::: " + readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //endregion

        //region NIO == commons-io
        lines(get("test_unicode.txt"))
            .forEach(System.out::println);
        //endregion
    }
}
