package com.acme.edu.printer;

import com.acme.edu.server.ServerException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
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
    private String encoding;
    private List<String> bufferMessages = new ArrayList<>(SIZE_BUFFER);
    //private DataOutputStream dos;

    //endregion

    /**
     * Initialize host and number port
     *
     * @param host for example 127.0.0.1
     * @param port for example 1500
     */
    public RemotePrinter(String host, int port, String encoding) throws PrinterException {
        this.encoding = encoding;
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
             BufferedWriter bufferWriterMessage = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),encoding))) {
            bufferWriterMessage.write(bufferMessages.toString());
            bufferWriterMessage.flush();
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
            throw (ServerException) serverMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new PrinterException(e);
        }
    }
}
