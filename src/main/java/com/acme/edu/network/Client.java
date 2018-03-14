package com.acme.edu.network;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6666)) {

            socket.getInputStream();
            socket.getOutputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
