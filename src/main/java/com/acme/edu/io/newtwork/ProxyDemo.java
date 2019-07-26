package com.acme.edu.io.newtwork;

public class ProxyDemo {
    public static void main(String[] args) {
        final ServerLoggerProxy logger
                = new ServerLoggerProxy("localhost", 666);

        logger.log(5);

        logger.close();

    }
}

class ServerLoggerProxy {
    public ServerLoggerProxy(String localhost, int port) {

    }

    public void log(int i) {

    }

    public void close() {

    }
}