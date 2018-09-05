package com.acme.edu.server;

import com.acme.edu.Logger;
import com.acme.edu.controller.LogOperationException;
import com.acme.edu.message.IntMessage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

import static java.lang.Thread.interrupted;
import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * Created by Java_1 on 04.09.2018.
 */
public class Server {
    public static void main(String[] args) throws ClassNotFoundException, IOException{
        ServerSocket portListener = new ServerSocket(6666);
        ExecutorService pool = newFixedThreadPool(10_000);

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

        //pool.shutdown();
    }
}

