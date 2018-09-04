package io;

import java.io.*;

import static java.lang.Thread.sleep;

public class WriteTest {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        try (PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream("out.txt", true)
                        )
                )
        )) {

            while(true) {
                out.println(args[0]);
                out.flush();
                sleep(1_000);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
