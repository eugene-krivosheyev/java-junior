package com.acme.edu.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

import static java.lang.Thread.interrupted;
import static java.util.concurrent.Executors.newFixedThreadPool;

public class Server {
    public static void main(String[] args) {
        ExecutorService pool = newFixedThreadPool(10_000);
        new Thread(() -> {
            try (ServerSocket portListener = new ServerSocket(6666)) {
                    while (!interrupted()) {
                        Socket clientConnection = portListener.accept();
                        PrintWriter out = new PrintWriter(
                                new OutputStreamWriter(
                                        new BufferedOutputStream(
                                                clientConnection.getOutputStream())));
                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                        new BufferedInputStream(
                                                clientConnection.getInputStream())));
                        pool.execute(new Session(in, out));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }).start();
    }
}

class Session implements Runnable {
    private BufferedReader reader;
    private PrintWriter writer;

    public Session(BufferedReader in, PrintWriter out) {
        reader = in;
        writer = out;
    }

    @Override
    public void run() {
        try {
            String line;
            CommandMapper commandMapper = new CommandMapper();
            int loggerResult = 200;
            while ((line = reader.readLine()) != null) {
                loggerResult = commandMapper.mapAndExecute(line);
            }
            System.out.println(String.valueOf(loggerResult));
            writer.println();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
