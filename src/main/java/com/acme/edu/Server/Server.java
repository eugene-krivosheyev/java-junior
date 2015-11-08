package com.acme.edu.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Павел on 07.11.2015.
 */
public class Server implements Runnable {
    //region fields
    private static int port;
    private static final String FILE_MESSAGES = "serverOut.txt";
    private static final String FILE_OBJECTS = "objects.txt";
    private static DataInputStream dataInputStream;
    //endregion

    public Server(int port) throws IOException {
        this.port = port;
    }

    public void startServer() throws ServerException {
        try (ServerSocket serverSocket = getSereverSocket()) {
            while (true) {
                serverSocket.setSoTimeout(12_000);
                Socket client = serverSocket.accept();
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
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_OBJECTS));
            out.writeObject(e);
            out.close();
        } catch (IOException ex) {
            serializeException(ex);
        }
        //отправить эксепшн на клиент???
    }
    public ServerSocket getSereverSocket(){
        try {
            return new ServerSocket(6666);
        } catch (IOException e) {
            serializeException(e);
            return null;
        }
    }

    @Override
    public void run() {
        try {
            startServer();
        } catch (ServerException e) {
            serializeException(e);
        }
    }
}
