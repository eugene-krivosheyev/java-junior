package com.acme.edu.it;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.message.StringMessage;
import com.acme.edu.message.decorator.DefaultDecorator;
import com.acme.edu.remote.Client;
import com.acme.edu.remote.RemoteConfiguration;
import com.acme.edu.remote.Server;
import com.acme.edu.remote.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;
import static java.util.concurrent.Executors.newFixedThreadPool;

public class ClientServerTest implements SysoutCaptureAndAssertionAbility {
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    @Test
    public void runMultipleClientsForOneServer() throws IOException, LoggerDecoratorException, InterruptedException {
        Server server = new Server();
        server.start();
        Client client1  = new Client();
        client1.addMessageToPool(new StringMessage("client 1 test 1", new DefaultDecorator("string")));
        client1.addMessageToPool(new StringMessage("client 1 test 2", new DefaultDecorator("string")));
        client1.addMessageToPool(new StringMessage("client 1 test 3", new DefaultDecorator("string")));

        Client client2  = new Client();
        client2.addMessageToPool(new StringMessage("client 2 test 1", new DefaultDecorator("string")));
        client2.addMessageToPool(new StringMessage("client 2 test 2", new DefaultDecorator("string")));
        client2.addMessageToPool(new StringMessage("client 2 test 3", new DefaultDecorator("string")));

        ExecutorService pool = newFixedThreadPool(2);

        Thread t1 = new Thread(() -> {
            try {
                client1.sendMessagePool();
            } catch (LoggerDecoratorException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                client2.sendMessagePool();
            } catch (LoggerDecoratorException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        server.stop();
        assertSysoutContains("client 1");
        assertSysoutContains("client 2");
        assertSysoutContains("test 1");
        assertSysoutContains("test 2");
        assertSysoutContains("test 3");
    }
}
