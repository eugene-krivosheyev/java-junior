package com.acme.edu.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Павел on 07.11.2015.
 */
public class Server implements Runnable {
    //region fields
    private int port;
    private static final String FILE_MESSAGES = "serverOut.txt";
    private static final String FILE_OBJECTS = "objects.txt";
    private Socket client;
    private DataInputStream dataInputStream;
    //endregion

    /**
     * Initialize number port
     * @param port the port number
     * @throws IOException
     */
    public Server(int port) throws IOException {
        this.port = port;
    }

    public void startServer() throws ServerException {
        try (ServerSocket serverSocket = new ServerSocket(6666)) {
            while(true) {
                serverSocket.setSoTimeout(12_000);
                client = serverSocket.accept();
                dataInputStream = new DataInputStream(client.getInputStream());
                writeToFile(dataInputStream.readUTF());
                dataInputStream.close();
            }
        } catch (IOException e) {
            serializeException(e);
        }
    }

    private void writeToFile(String message) {
        try {
            FileWriter fw = new FileWriter(FILE_MESSAGES, true);
            fw.write(message);
            fw.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            serializeException(e);
        } catch (IOException e) {
            serializeException(e);
        }
    }

    private void serializeException(Exception e) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            out.writeObject(e);
            out.close();
        } catch (IOException ex) {
            serializeException(ex);
        }
    }

    /**
     * Start server.
     * For multiThreading
     */
    @Override
    public void run() {
        try {
            startServer();
        } catch (ServerException e) {
            serializeException(e);
        }
    }
}
