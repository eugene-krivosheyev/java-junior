package com.acme.edu.iteration13;

import com.acme.edu.network.ClientStub;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

public class MultiThreadTest {
    private ClientStub client = new ClientStub();

    public MultiThreadTest() throws IOException {
    }

    @Test
    public void shouldWork() {
    }

    @Test
    public void shouldWork2() {
        try (Scanner in = new Scanner(System.in)) {
            String message = "";
            while (!message.equals("close") || !message.equals("exit")) {
                message = in.nextLine();
                client.log(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
