package com.acme.edu;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        Socket clientSocket = null;

        try {
            ServerSocket ss = new ServerSocket(6666);

            clientSocket = ss.accept();
            System.out.println("addr: " + clientSocket.getInetAddress());

            DataInputStream is = new DataInputStream(clientSocket.getInputStream());
            String readLine;
            while ((readLine = is.readUTF()) != null) {
                System.out.println(">>>> " + readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
