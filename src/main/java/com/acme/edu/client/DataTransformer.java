package com.acme.edu.client;

import com.acme.edu.exceptions.ConnectionException;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DataTransformer {
    private BufferedReader in;
    private BufferedWriter out;
    private Executor executor;
    private Socket socket;

    DataTransformer(Socket socket) throws IOException {
        this.socket = socket;
        out = new BufferedWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(socket.getOutputStream())));
        in = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(socket.getInputStream())));
        executor = Executors.newSingleThreadExecutor();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            disconnect();
            System.out.println("Good bye!");
        }));
    }

    public void transform(String message) {
        //todo add encoding
        executor.execute(() -> {
            try {
                out.write(message);
                out.flush();
                System.out.println(in.readLine());
            } catch (IOException e) {
                e.printStackTrace();
                throw new ConnectionException(e);
            }
        });

    }

    private void disconnect() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ConnectionException(e);
        }
    }
}
