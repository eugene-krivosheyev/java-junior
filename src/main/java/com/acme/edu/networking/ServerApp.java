package com.acme.edu.networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        try(final ServerSocket connectionListener = new ServerSocket(666)) {
            final Socket socket = connectionListener.accept();

            try (final PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(
                                    new BufferedOutputStream(
                                            socket.getOutputStream())));
                 final BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    new BufferedInputStream(
                                            socket.getInputStream())))) {

                final String readLine = in.readLine();
                System.out.println("debug: " + readLine);
                out.println(">> " + readLine);
                out.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
