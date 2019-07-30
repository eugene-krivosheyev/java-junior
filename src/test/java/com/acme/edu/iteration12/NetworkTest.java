package com.acme.edu.iteration12;

import com.acme.edu.network.ClientStub;
import org.junit.*;

import java.io.*;

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
        boolean answer = readToStringFile(new File("journal.txt")).endsWith("100");
        Assert.assertEquals(answer,true);
    }
    //TODO:byte interpretation
    @Test
    public void shouldSaveStringMessage() throws Exception {
        client.log((byte) 10);
        client.log(100);
        client.log(200);
        client.log("Kirill");
        client.log('c');
        client.close();
        String mustEndWith = "10" + System.lineSeparator() +
                "300" + System.lineSeparator() +
                "Kirill" + System.lineSeparator() +
                "char: c";
        boolean answer = readToStringFile(new File("journal.txt")).endsWith(mustEndWith);
        Assert.assertEquals(answer,readToStringFile(new File("journal.txt")));
    }

    @Test
    public void shouldAccumulateByte() throws Exception {
        client.log((byte) 10);
        client.log((byte) 23);
        client.close();
    }

    private String readToStringFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(file)), "UTF-16"));
        StringBuilder answer = new StringBuilder("");
        reader.lines().map((i)->i+System.lineSeparator()).forEachOrdered(answer::append);
        reader.close();
        return answer.toString();
    }
}
