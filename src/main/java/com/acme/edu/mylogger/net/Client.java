package com.acme.edu.mylogger.net;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try (
                final Socket socket = new Socket("localhost", 666);
                final PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(
                                new BufferedOutputStream(socket.getOutputStream())));
                final BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(socket.getInputStream())));
        ) {

            out.println(args[0]);
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
