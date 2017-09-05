package com.acme.edu.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServerDemo {
    public static void main(String[] args) {
        try (
            ServerSocket serverSocket = new ServerSocket(6666);
        ) {

//            serverSocket.setSoTimeout(1_000);
            Socket client = serverSocket.accept();

            DataInputStream dataInputStream
                    = new DataInputStream(client.getInputStream());

            System.out.println(">>> " + dataInputStream.readUTF());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
