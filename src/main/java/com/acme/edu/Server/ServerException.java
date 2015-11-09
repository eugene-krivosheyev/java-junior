package com.acme.edu.server;

import com.acme.edu.printer.PrinterException;

import java.io.Serializable;

/**
 * Created by Павел on 07.11.2015.
 */
public class ServerException extends PrinterException implements Serializable {

    /**
     * Different exceptions occur when the server is running
     * @param cause type Exception
     */
    public ServerException(Throwable cause) {
        super(cause);
    }

}
