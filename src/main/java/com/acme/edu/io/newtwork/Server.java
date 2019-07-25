package com.acme.edu.io.newtwork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//NIO2: Async/non-blocking IO + native
public class Server {
    public static void main(String[] args) {
        try (final ServerSocket serverSocket = new ServerSocket(666)) {
            while (true) {
//                serverSocket.setSoTimeout(10_000);
                Socket client = serverSocket.accept();

                try (BufferedReader in =
                             new BufferedReader(
                                     new InputStreamReader(
                                             new BufferedInputStream(
                                                     client.getInputStream())));
                     final BufferedWriter out =
                             new BufferedWriter(
                                     new OutputStreamWriter(
                                             new BufferedOutputStream(
                                                     client.getOutputStream())))) {

                    while (true) {
                        out.write(">>> " + in.readLine());
                        out.newLine();
                        out.flush();
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
