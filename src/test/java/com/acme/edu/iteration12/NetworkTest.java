package com.acme.edu.iteration12;

import com.acme.edu.network.ClientStub;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class NetworkTest {
    private ClientStub client = new ClientStub();

    public NetworkTest() throws IOException {
    }

    @Before
    public void setUp() throws IOException {
        //client = new ClientStub();
    }

    @After
    public void closeAll() throws IOException {
        //client.close();
    }

    @Test
    public void shouldSaveMessage() throws Exception {
        client.log(100);
        client.close();
    }

    @Test
    public void shouldSaveStringMessage() throws Exception {
        client.log((byte)10);
        client.log(100);
        client.log(200);
        client.log("Kirill");
        client.log('c');
        client.exit();
    }

    @Test
    public void shouldAccumulateByte() throws Exception {
        client.log((byte)10);
        client.log((byte)23);
    }
}
