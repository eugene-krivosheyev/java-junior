package com.acme.edu.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Павел on 07.11.2015.
 */
public class Server{
    //region fields
    private int port;
    private static final String FILE_MESSAGES = "serverOut.txt";
    private Socket client;
    private DataInputStream dataInputStream;
    //endregion

    /**
     * Initialize number port
     *
     * @param port the port number
     * @throws IOException
     */
    public Server(int port) throws IOException {
        this.port = port;
    }


    private void startServer() throws ServerException, IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(10000);
            client = serverSocket.accept();
            dataInputStream = new DataInputStream(client.getInputStream());
            writeToFile(dataInputStream.readUTF());
            dataInputStream.close();
        } catch (IOException e) {
            serializeException(e);
        }
    }

    private void writeToFile(String message) throws IOException {
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

    private void serializeException(Exception e) throws IOException {

        ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
        out.writeObject(e);
        out.close();
    }
}
