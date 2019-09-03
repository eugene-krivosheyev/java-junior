package com.acme.edu.network;

import com.acme.edu.Saver.FileSaver;
import com.acme.edu.Saver.SuperSaver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerApp {
    private SuperSaver saver = new FileSaver();

    public static void main(String[] args) {
        new ServerApp().startServer();
    }

    private void startServer() {
        try (
                final ServerSocket connectionListener = new ServerSocket(8080)
        ) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            registerShutdownHook(executorService);
            while (true) {
                Socket socket = connectionListener.accept();
                executorService.execute(() -> {
                    try (final PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(
                                    new BufferedOutputStream(
                                            socket.getOutputStream())));
                         final BufferedReader in = new BufferedReader(
                                 new InputStreamReader(
                                         new BufferedInputStream(
                                                 socket.getInputStream())))) {
                        processClient(in, out);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerShutdownHook(ExecutorService executorService) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            executorService.shutdown();
            System.out.println("Server closed");
        }));
    }

    private void processClient(BufferedReader in, PrintWriter out) {
        try {
            String readLine = in.readLine();
            while (!("close".equals(readLine))) {
                System.out.println("debug: " + readLine);
                saver.save(readLine);
                readLine = in.readLine();
            }
            out.println("Success");
            System.out.println("client closed");
        } catch (IOException e) {
            System.out.println("Error in processClient");
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        } finally {
            out.flush();
        }
    }
}
