package com.acme.edu;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Accepter {


    public void accept() {
        try (final ServerSocket socket = new ServerSocket(432)) {
            while(true) {
                Socket client = socket.accept();
                try (BufferedReader in =
                             new BufferedReader(
                                     new InputStreamReader(
                                             new ObjectInputStream(
                                                     client.getInputStream())))) {

                }
            }
        } catch (IOException e) {

        }
    }
}
