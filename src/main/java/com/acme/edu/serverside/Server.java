package com.acme.edu.serverside;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket portListener = new ServerSocket(6666)) {
            try (Socket clientConnection = portListener.accept();
                 PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(
                                    new BufferedOutputStream(
                                            clientConnection.getOutputStream())));
                 BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    new BufferedInputStream(
                                            clientConnection.getInputStream())));
            ) {
                String line = null;
                while ((line = in.readLine()) != null) {
                    Handler.parse(line);
               }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
