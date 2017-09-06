package com.acme.edu.objectprotocol;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6666);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter((socket.getOutputStream())));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.write("123");
    }
}
