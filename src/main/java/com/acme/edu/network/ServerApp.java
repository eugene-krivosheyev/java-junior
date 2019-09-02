package com.acme.edu.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerApp {
    public static void main(String[] args) {
        try (
                final ServerSocket connectionListener = new ServerSocket(8080)
                ) {
            ExecutorService executorService = Executors.newFixedThreadPool(8);
            Runtime.getRuntime().addShutdownHook(new ShutdownThread(executorService));
            while(true) {
                Socket socket = connectionListener.accept();
                executorService.execute(() -> processClient(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processClient(Socket socket) {
        try (
                final PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(
                                new BufferedOutputStream(
                                        socket.getOutputStream())));
                final BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(
                                        socket.getInputStream())))) {

            String readLine = in.readLine();
            while (!("close".equals(readLine))) {
                System.out.println("debug: " + readLine);
                out.println(">> " + readLine);
                out.flush();
                readLine = in.readLine();
            }
            System.out.println("client closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ShutdownThread extends Thread {
    private final ExecutorService executorService;

    public ShutdownThread(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void run() {
        executorService.shutdown();
        System.out.println("Server closed");
    }
}
