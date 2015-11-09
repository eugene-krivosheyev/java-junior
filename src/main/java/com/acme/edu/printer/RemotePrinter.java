package com.acme.edu.printer;

import com.acme.edu.server.ServerException;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Павел on 07.11.2015.
 */
public class RemotePrinter implements Printable{

    //region fields
    private int buffer = 0;
    private Socket server;
    private String encoding;
    private List<String> bufferMessages = new ArrayList<>(50);
    private BufferedWriter bufferWriterMessage;
    private ObjectInputStream serverMessage;
    //private DataOutputStream dos;

    //endregion

    /**
     * Initialize hoost and number port
     * @param host for example 127.0.0.1
     * @param port for example 1500
     */
    public RemotePrinter(String host, int port, String encoding) throws PrinterException {
        this.encoding = encoding;
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
        bufferMessages.add(message + SEP);
        if (checkBuffer()) {
            sendMessage();
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

    private void sortBuffer(){
        Collections.sort(bufferMessages, (o1, o2) -> {
            if (o1.contains("ERROR"))
                return -1;
            else if (o1.equals(o2))
                return 0;
            else return 1;
        });
    }

    private void deserializationException() throws PrinterException{
        try {
            serverMessage = new ObjectInputStream(server.getInputStream());
            printerException.listExciption.add((ServerException) serverMessage.readObject());
        } catch (IOException  | ClassNotFoundException e) {
            printerException.listExciption.add(e);
            throw printerException;
        } finally {
            if (serverMessage != null){
                try {
                    serverMessage.close();
                } catch (IOException e) {
                    printerException.listExciption.add(e);
                    throw printerException;
                }
            }
        }
    }

    private void sendMessage() throws PrinterException {
        try (Socket socket = server) {
            bufferWriterMessage = new BufferedWriter(new OutputStreamWriter(server.getOutputStream(), encoding));
            sortBuffer(); //сортировка буфера
            bufferWriterMessage.write(bufferMessages.toString());
            bufferWriterMessage.flush();
            bufferMessages.clear();

            if (socket.getInputStream().available() > 0){
                deserializationException();
            }

        } catch (IOException e) {
            printerException.listExciption.add(e);
            throw printerException;
        } finally {
            if (bufferWriterMessage != null){
                try {
                    bufferWriterMessage.close();
                } catch (IOException e) {
                    printerException.listExciption.add(e);
                    throw printerException;
                }
            }
        }
    }
}
