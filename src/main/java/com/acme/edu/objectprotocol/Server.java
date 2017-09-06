package com.acme.edu.objectprotocol;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket socket = serverSocket.accept();

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter((socket.getOutputStream())));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        in.readLine();
    }

}
