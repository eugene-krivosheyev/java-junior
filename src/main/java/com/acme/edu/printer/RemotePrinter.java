package com.acme.edu.printer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Павел on 07.11.2015.
 */
public class RemotePrinter implements Printable {

    //region fields
    private String host;
    private int port;
    private int buffer = 0;
    private DataOutputStream dataOutputStreams;
    private StringBuilder stringBuilder = new StringBuilder();
    //endregion

    /**
     * Initialize hoost and number port
     * @param host for example 127.0.0.1
     * @param port for example 1500
     */
    public RemotePrinter(String host, int port) {
        this.host = host;
        this.port = port;
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
        if (buffer < SIZE_BUFFER) {
            buffer++;
        } else {
            buffer = 0;
            try (
                    Socket socket = new Socket(host, port)
            ) {
                dataOutputStreams = new DataOutputStream(socket.getOutputStream());
                dataOutputStreams.writeUTF(stringBuilder.toString());
                stringBuilder.setLength(0);
            } catch (IOException e) {
                printerException.listExciption.add(e);
                throw printerException;
            }
        }
    }
}
