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
    private DataOutputStream dos;
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
        if (checkBuffer()) {
            try (Socket socket = getSocket()) {
                dos = getStream(socket);
                dos.writeUTF(stringBuilder.toString());
                dos.close();
                stringBuilder.setLength(0);
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

    public Socket getSocket() throws IOException {
        return new Socket(host, port);
    }

    private DataOutputStream getStream(Socket socket) throws IOException {
        return new DataOutputStream(socket.getOutputStream());
    }
}
