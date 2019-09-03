package com.acme.edu;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;

/**
 * Created by kate-c on 30/08/2019.
 */
public class LoggerClientStub {
    public static void main(String[] args) {
        for (int i = 0; i < 5; ++i) {
            final int j = i;
            final Thread thread2 = new Thread(() -> {
                clientTest(j);
            });
            thread2.run();
        }
    }

    private static void clientTest(int i) {
        try (
                final Socket socket = new Socket("localhost", 666);
                final PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(
                                new BufferedOutputStream(socket.getOutputStream())));
                final BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(socket.getInputStream())));
                )
        {
            out.println("IntCommand " + (i * 10 + 1));
            out.println("IntCommand " + (i * 10 + 2));
            out.println("IntCommand " + (i * 10 + 3));
            out.println("StringCommand eto message" + i);
            out.println("Flush Sooqa!");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
