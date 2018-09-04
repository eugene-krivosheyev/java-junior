package com.acme.edu.iteration04;

import com.acme.edu.net.ClientStub;
import org.junit.Test;

public class ClientServerTest {
    @Test
    public void shouldGetZeroResultWhenSendLogRequestToServer() {
        ClientStub clientStub = new ClientStub();
        clientStub.log(123);
    }
}
