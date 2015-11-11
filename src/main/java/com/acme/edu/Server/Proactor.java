package com.acme.edu.server;

import java.io.*;
import java.net.Socket;

/**
 * Created by Павел on 10.11.2015.
 */
public class Proactor implements Runnable {

    //region fields
    private Socket client;
    private String encoding;
    private final Object monitor;
    private static final String FILE_MESSAGES = "serverOut.txt";
    //endregion

    public Proactor(Socket socket, String encoding, Object monitor) {
        this.encoding = encoding;
        this.client = socket;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try (DataInputStream dataInputStream = new DataInputStream(client.getInputStream())) {
            writeToFile(dataInputStream.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServerException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(String message) throws ServerException {
        synchronized (monitor) {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_MESSAGES, true), encoding))) {
                bw.write(message);
            } catch (IOException e) {
                throw new ServerException(e);
            }
        }
    }
}