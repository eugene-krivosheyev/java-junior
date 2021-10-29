package com.acme.edu;

import java.util.Objects;

public class Printer {
    public void print(String message) throws IllegalStringToPrintExeption{
        if (Objects.equals(message,"")) {
            throw new IllegalStringToPrintExeption("Bad message to print!");
        }
        System.out.println(message);
    }
}
