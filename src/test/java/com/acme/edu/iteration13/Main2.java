package com.acme.edu.iteration13;

import com.acme.edu.network.ClientStub;

import java.io.IOException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws IOException {
        ClientStub client = new ClientStub();
        try(Scanner in = new Scanner(System.in)){
            String message = "";
            //message = in.nextLine();
            while(!(message.equals("close") ^ message.equals("exit"))) {
                client.log("Kirill");
                //message = in.nextLine();
                client.close();
                break;
            }
            if(message.equals("close"))
                client.close();
            else if (message.equals("exit"))
                client.exit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
