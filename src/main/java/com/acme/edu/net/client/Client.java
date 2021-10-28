package com.acme.edu.net.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try(
                final Socket socket = new Socket("127.0.0.1", 9999);
                final DataInputStream input = new DataInputStream(
                        new BufferedInputStream(socket.getInputStream()));
                final DataOutputStream out = new DataOutputStream(
                        new BufferedOutputStream(socket.getOutputStream()))
        ) {
            out.writeUTF("string,str1");
            out.writeUTF("flush");
            out.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
