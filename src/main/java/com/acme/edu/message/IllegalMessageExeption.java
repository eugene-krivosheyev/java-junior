package com.acme.edu.message;

public class IllegalMessageExeption extends Exception{
    public IllegalMessageExeption(String msg){
        super(msg);
    }

    public IllegalMessageExeption(){
        super();
    }
}
