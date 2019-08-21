package com.acme.edu;


import java.lang.reflect.Type;
import java.util.function.Function;
import java.util.*;
public class Logger {

    public static void  log(Object message) {
        if (message instanceof Boolean || message instanceof Long || message instanceof Integer || message instanceof Byte)
            System.out.println("primitive: " + message);
        else if (message instanceof String)
            System.out.println("string: " + message);
        else if (message instanceof Character)
            System.out.println("char: " + message);
        else
            System.out.println("reference: " + message);
    }


}
