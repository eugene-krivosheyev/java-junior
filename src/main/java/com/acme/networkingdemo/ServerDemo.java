package com.acme.networkingdemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket connectionListener = new ServerSocket(9999);
//        connectionListener.setSoTimeout(1_000);

        try (
                Socket connection = connectionListener.accept();

                BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(
                                new BufferedOutputStream(
                                        connection.getOutputStream())));

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(
                                        connection.getInputStream())));
        ) {

            out.write("recieved: " + in.readLine());
            out.newLine();
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
