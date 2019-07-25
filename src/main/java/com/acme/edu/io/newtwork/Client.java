package com.acme.edu.io.newtwork;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try(final Socket server = new Socket("localhost", 666)) {

        try (final BufferedReader in =
                     new BufferedReader(
                             new InputStreamReader(
                                     new BufferedInputStream(
                                             server.getInputStream(), 100)));
             final BufferedWriter out =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new BufferedOutputStream(
                                             server.getOutputStream(), 10)))) {

            try (BufferedReader console =
                         new BufferedReader(
                                 new InputStreamReader(
                                         new BufferedInputStream(
                                                 System.in)))) {

                while (true) {
                    out.write(">>> " + console.readLine());
                    out.newLine();
                    out.flush();
                    System.out.println(in.readLine());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
