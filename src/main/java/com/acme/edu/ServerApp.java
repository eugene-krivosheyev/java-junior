package com.acme.edu;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);

            Socket client = ss.accept();
            System.out.println("addr: " + client.getInetAddress());

            DataInputStream is = new DataInputStream(client.getInputStream());
            String readLine;
            while ((readLine = is.readUTF()) != null) {
                System.out.println(">>>> " + readLine);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
