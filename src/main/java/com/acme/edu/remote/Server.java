package com.acme.edu.remote;

import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.loggerexceptions.LoggerErrors;
import com.acme.edu.message.Message;
import com.acme.edu.message.MessageWrapper;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;

import static java.lang.Thread.interrupted;
import static java.util.concurrent.Executors.newFixedThreadPool;


public class Server {
    ExecutorService pool = newFixedThreadPool(RemoteConfiguration.POOL_SIZE);


    public Server() throws IOException {
    }

    public void start() throws IOException {
        ServerSocket portListener = new ServerSocket(RemoteConfiguration.PORT_NUMBER);

        new Thread(() -> {
            try {
                while (!interrupted()) {
                    Socket clientSession = portListener.accept();
                    pool.execute(new Session(clientSession));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public void stop() throws IOException {
        pool.shutdownNow();
    }


}
