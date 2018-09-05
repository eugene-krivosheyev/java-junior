package com.acme.edu.iteration04;

import com.acme.edu.net.ClientStub;
import org.junit.Test;

public class ClientServerTest {
    @Test
    public void shouldGetZeroResultWhenSendLogRequestToServer() {

        Thread t1 = new Thread(() -> {
            ClientStub clientStub = new ClientStub();
            for (int i = 0; i < 50; ++i) {
                clientStub.log((int)(Thread.currentThread().getId()));
                clientStub.log((int)(Thread.currentThread().getId()));
                clientStub.log((int)(Thread.currentThread().getId()));
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            ClientStub clientStub = new ClientStub();
            for (int i = 0; i < 50; ++i) {
                clientStub.log((int)(Thread.currentThread().getId()));
                clientStub.log((int)(Thread.currentThread().getId()));
                clientStub.log((int)(Thread.currentThread().getId()));
            }
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            ClientStub clientStub = new ClientStub();
            for (int i = 0; i < 50; ++i) {
                clientStub.log((int)(Thread.currentThread().getId()));
                clientStub.log((int)(Thread.currentThread().getId()));
                clientStub.log((int)(Thread.currentThread().getId()));
            }
        });
        t3.start();

        Thread t4 = new Thread(() -> {
            ClientStub clientStub = new ClientStub();
            for (int i = 0; i < 50; ++i) {
                clientStub.log((int)(Thread.currentThread().getId()));
                clientStub.log((int)(Thread.currentThread().getId()));
                clientStub.log((int)(Thread.currentThread().getId()));
            }
        });
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
