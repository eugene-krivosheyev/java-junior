package com.acme.edu.io.newtwork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MutithreadedServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(666);

        new Thread(() -> {
            while (true) {
                try {
                    final Socket client = serverSocket.accept();
                    new Session(client).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class Session extends Thread {
    private Socket client;
    private BufferedReader in;
    private BufferedWriter out;

    public Session(Socket client) throws IOException {
        this.client = client;

        in = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                client.getInputStream())));
        out = new BufferedWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                client.getOutputStream())));
    }

    @Override
    public void run() {
        while (true) {
            try {
                out.write(">>> " + in.readLine());
                out.newLine();
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
