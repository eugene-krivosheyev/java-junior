package com.acme.edu.Server;

import java.io.Serializable;

/**
 * Created by Павел on 07.11.2015.
 */
public class ServerException extends Exception implements Serializable {

    public ServerException(Throwable cause) {
        super(cause);
    }
}
