package com.acme.edu.reflectiondemo;

public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //white magic: introspection
        Class<?> clazz = Class.forName("com.jet.edu.Logger");
        clazz.getAnnotations();
        clazz.newInstance();

        //gray magic: virtual proxy a la Spring

        //black magic: byte-code manipulation - ByteBuddy, ASM
    }
}
