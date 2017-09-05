package com.acme.edu.network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkDemoClient {
    public static void main(String[] args) {
        try (
            Socket socket = new Socket("127.0.0.1", 6666);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(outputStream);
        ) {

            out.writeUTF("HELLO!!!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
