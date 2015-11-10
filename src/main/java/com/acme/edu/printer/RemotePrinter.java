package com.acme.edu.printer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Павел on 07.11.2015.
 */
public class RemotePrinter extends PrinterManager {

    //region fields
    private String host;
    private int port;
    private List<String> bufferMessages = new ArrayList<>(SIZE_BUFFER);
    //endregion

    /**
     * Initialize host and number port
     *
     * @param host for example 127.0.0.1
     * @param port for example 1500
     */
    public RemotePrinter(String host, int port) throws PrinterException {
        this.host = host;
        this.port = port;
    }

    /**
     * The accumulation buffer and flush buffer.
     * Remote printing on server
     *
     * @param message
     * @throws PrinterException
     */
    @Override
    public void print(String message) throws PrinterException {
        bufferMessages.add(message + SEP);
        if (checkBuffer(bufferMessages)) {
            sortBuffer(bufferMessages); //сортировка буфера
            sendMessage();
        }
    }

    private void sendMessage() throws PrinterException {
        try (Socket socket = new Socket(host, port);
             DataOutputStream dataStreamMessages = new DataOutputStream(socket.getOutputStream())) {

            dataStreamMessages.writeUTF(bufferMessages.toString());
            dataStreamMessages.flush();
            bufferMessages.clear();
            getMessage(socket);
        } catch (IOException e) {
            throw new PrinterException(e);
        }
    }

    private void getMessage(Socket socket) throws PrinterException {
        try {
            if (socket.getInputStream().available() > 0) {
                deserializationException(socket);
            }
        } catch (IOException e) {
            throw new PrinterException(e);
        }
    }

    private void deserializationException(Socket socket) throws PrinterException {
        try(ObjectInputStream serverMessage = new ObjectInputStream(socket.getInputStream())) {
            String message =  serverMessage.readUTF();
            if (!message.equals("OK")) {
                throw new PrinterException(message);
            }
        } catch (IOException e) {
            throw new PrinterException(e);
        }
    }
}
