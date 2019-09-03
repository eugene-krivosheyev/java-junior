package com.acme.edu.network;

import java.io.*;
import java.net.Socket;

import static java.lang.Thread.currentThread;

public class ClientApp {
    public static void main(String[] args) {
        Thread thread1 = new Thread(ClientApp::createClient);
        Thread thread2 = new Thread(ClientApp::createClient);

        thread1.start();
        thread2.start();
    }

    private static void createClient() {
        try (
                final Socket socket = new Socket("localhost", 8080);
                final PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(
                                new BufferedOutputStream(socket.getOutputStream())));
                final BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(socket.getInputStream())))
        ) {
            sendMessage(out, in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMessage(PrintWriter out, BufferedReader in) throws IOException {
        String name = currentThread().getName();
        for(int i=0; i< 1000; i++){
            out.println(name + " StringCommand nertrfd");
            out.println(name + " StringCommand gkjfdgkjd");
            out.println(name + " IntCommand 12");
            out.println(name + " IntCommand 7");
            out.flush();
        }
        out.println("close");
        out.flush();
        System.out.println(in.readLine());
    }


}
