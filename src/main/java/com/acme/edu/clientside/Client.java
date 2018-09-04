package com.acme.edu.clientside;

import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        try(LoggerProxy loggerProxy = new LoggerProxy("127.0.0.1", 6666)) {

            loggerProxy.log(10);
            loggerProxy.log((byte) 10);
            loggerProxy.log("string");
            loggerProxy.flush();
        } catch (IOException e) {

        }
    }
}
