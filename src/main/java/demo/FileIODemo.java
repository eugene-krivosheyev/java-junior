package demo;


import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class FileIODemo {
    /**
     * Blocking sync IO
     */
    public static void main(String[] args) {
        /*
        Files.readAllLines();
        Files.lines().forEach(System.out::println);

        Files.write();
        */

        try (RandomAccessFile raf = new RandomAccessFile("demo.txt", "rw");) {
            java.io.File fileInfo = new File("dir", "subdir/test.txt");
            fileInfo.exists(); //???
            fileInfo.createNewFile();
            fileInfo.mkdir();

            /**
             * !SRP: seek + In/OutStream + DataIn/OutStream
             */

            raf.seek(0L);
            raf.close(); //!!!
        } catch (IOException e) {
            e.printStackTrace();
        }

        //writing?
//        BufferedWriter bw; bw.write(""); bw.newLine();
//        PrintWriter pw; pw.printf("");

        //Object saving: serialization

        //append? FileOutputStream

        //when to close?

        //flushing
        //buffering trade-off
        InputStream in;
        try (BufferedReader br =
                 new BufferedReader(
                     new InputStreamReader(
//                     new DataInputStream( //ObjectInputStream
                           new BufferedInputStream(
                                    new FileInputStream("data.txt")), StandardCharsets.UTF_8))){

            String readLine = null;
            while ((readLine = br.readLine()) != null) {
                System.out.println(">> " + readLine);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        /*
        new DataOutputStream(????).writeDouble(4.1);
        new DataInputStream().readDouble();
        new DataInputStream().readUTF();
        */

    }
}
