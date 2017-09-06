package com.acme.edu.serverdemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(() -> {
                try (
                    DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                ) {

                    while (true) {
                        out.writeUTF(">>> " + input.readUTF());
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
