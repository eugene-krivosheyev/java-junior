package com.acme.edu;

/**
 * Created by Павел on 02.11.2015.
 */
public class Printer implements Printable{
    protected Printer(){
    }
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
