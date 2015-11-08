package com.acme.edu.printer;

import com.acme.edu.server.ServerException;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by Павел on 07.11.2015.
 */
public class RemotePrinter implements Printable {

    //region fields
    private String host;
    private int port;
    private int buffer = 0;
    private Socket server;
    private DataOutputStream dos;

    private StringBuilder stringBuilder = new StringBuilder();
    //endregion

    /**
     * Initialize hoost and number port
     * @param host for example 127.0.0.1
     * @param port for example 1500
     */
    public RemotePrinter(String host, int port) throws PrinterException {
        this.host = host;
        this.port = port;
        try {
            server = new Socket(host,port);
        } catch (IOException e) {
            printerException.listExciption.add(e);
            throw printerException;
        }
    }

    /**
     * The accumulation buffer and flush buffer.
     * Remote printing on server
     * @param message
     * @throws PrinterException
     */
    @Override
    public void print(String message) throws PrinterException {
        stringBuilder.append(message + SEP);
        if (checkBuffer()) {
            try (Socket socket = server) {
                dos = getOutStream(socket);
                dos.writeUTF(stringBuilder.toString());
                dos.close();
                stringBuilder.setLength(0);
                if (socket.getInputStream().available() > 0){
                    deserializationException();
                }
            } catch (IOException e) {
                printerException.listExciption.add(e);
                throw printerException;
            }
        }
    }

    private boolean checkBuffer(){
        if (buffer < SIZE_BUFFER) {
            buffer++;
            return false;
        } else {
            buffer = 0;
            return true;
        }
    }

    private DataOutputStream getOutStream(Socket socket) throws IOException {
        return new DataOutputStream(socket.getOutputStream());
    }

    private void deserializationException() throws PrinterException {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(server.getInputStream());
            printerException.listExciption.add((ServerException) objectInputStream.readObject());
        } catch (IOException  | ClassNotFoundException e) {
            printerException.listExciption.add(e);
            throw printerException;
        }
    }
}
