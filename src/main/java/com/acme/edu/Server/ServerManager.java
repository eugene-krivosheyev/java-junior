package com.acme.edu.server;

import java.io.*;
import java.net.Socket;

/**
 * Created by Павел on 10.11.2015.
 */
public class ServerManager implements Runnable {

    //region fields
    private Socket client;
    private String encoding;
    private Object monitor = new Object(); // запись в файл
    private static final String FILE_MESSAGES = "serverOut.txt";
    //endregion

    public ServerManager(Socket socket, String encoding) {
        this.encoding = encoding;
        this.client = socket;
    }

    @Override
    public void run() {
        try (DataInputStream dataInputStream = new DataInputStream(client.getInputStream())) {
            writeToFile(dataInputStream.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized void writeToFile(String message) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_MESSAGES, true), encoding))) {
            bw.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}