package com.acme.edu.client;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataTransformer {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private ExecutorService executor;
    private DataOutputStream out;
    private BufferedReader in;
    private Socket socket;

    DataTransformer() throws IOException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Good bye!")));
        this.socket = new Socket(HOST, PORT);
        this.out =
                new DataOutputStream(
                        new BufferedOutputStream(socket.getOutputStream()));
        this.in = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(socket.getInputStream())));
        this.executor = Executors.newSingleThreadExecutor();
    }

    public void run(String message) {
        try {
            executor.submit(() -> {
                try {
                    out.writeUTF(message);
                    out.flush();
                    System.out.println(in.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                    disconnect();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            disconnect();
        }
    }

    public void disconnect() {
        try {
            if (socket != null && !socket.isClosed()) {
                in.close();
                out.close();
                socket.close();
                executor.shutdownNow();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
