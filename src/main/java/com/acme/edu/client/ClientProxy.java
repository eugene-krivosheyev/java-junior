package com.acme.edu.client;

import java.io.*;
import java.net.Socket;

public class ClientProxy {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    public void run(String message) {
        try (
                final Socket socket = new Socket(HOST, PORT);
                final DataOutputStream out =
                        new DataOutputStream(
                                new BufferedOutputStream(socket.getOutputStream()));
                final BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(socket.getInputStream())))
        ) {
            out.writeUTF(message);
            out.flush();
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
