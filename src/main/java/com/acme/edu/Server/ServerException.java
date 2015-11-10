package com.acme.edu.server;

/**
 * Created by Павел on 07.11.2015.
 */
public class ServerException extends Exception {

    /**
     * Different exceptions occur when the server is running
     * @param cause type Exception
     */
    public ServerException(Throwable cause) {
        super(cause);
    }

    public ServerException(String message) {
        super(message);
    }
}
