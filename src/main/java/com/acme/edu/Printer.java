package com.acme.edu;

/**
 * Created by Павел on 02.11.2015.
 */
public class Printer implements Printable{
    @Override
    /**
     * print to console
     * @param message The <code>String</code> to be printed.
     */
    public void print(String message) {
        System.out.println(message);
    }
}
