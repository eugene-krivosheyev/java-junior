package com.acme.edu.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Павел on 07.11.2015.
 */
public class Server {
    //region fields
    private int port;
    private DataInputStream dataInputStream;
    private OutputStreamWriter osw;
    //endregion

    public Server(int port) throws IOException {
        this.port = port;
    }

    public void startServer() throws ServerException {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                System.out.println("test");
                Socket client = serverSocket.accept();
                dataInputStream = new DataInputStream(client.getInputStream());
                writeToFile(dataInputStream.readUTF());
            }
        }catch (IOException e){
            serializeException(e);
        }
    }

    private void writeToFile(String message) throws ServerException{
        try {
            osw = new OutputStreamWriter(new FileOutputStream("serverOut.txt", true), "UTF-8");
            osw.write(message);
        }catch (FileNotFoundException | UnsupportedEncodingException e){
            System.out.println("1");
            serializeException(e);
        } catch (IOException e){
            serializeException(e);
        }
    }

    private void serializeException(Exception e){
        try{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objects.dat"));
        out.writeObject(e);
        out.close();
        }catch (IOException ex){
            ex.getStackTrace();
        }
        //отправить эксепшн на клиент???
    }
}
