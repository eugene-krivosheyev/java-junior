package com.acme.edu;

import java.util.Date;

public class ReflectionDemo {
    public static void main(String[] args) {
        //Reflection: Introspection + Byte manipulation (ASM)

        try {
            //Получение мета-информации
            Class clazz = Class.forName("com.acme.edu.LoggerState");
            //LoggerState.class //ClassNotDefFoundError
            //new LoggerState().getClass();

            clazz.getMethods()[0].getParameterTypes();
            clazz.getAnnotations();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

@SuppressWarnings("unchecked")
class AnnotDemo {
    @Override
    @Deprecated
    public String toString() {
        return super.toString();
    }
}