package com.acme.edu.saver;

public class ConsoleSaver implements Saver{
    public void save(String toLog){
        System.out.println(toLog);
    }

}
