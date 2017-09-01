package com.acme.edu.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@SuppressWarnings({"unchecked","ddgdfg"})
public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        /**
         * Reflection:
         * - introspection
         * - virtual proxies
         * - byte-code generation and manipulation, instrumenting (ASM, ByteBuddy)
         */

        Class loadedClass = Class.forName("com.acme.MySuperClass");
        loadedClass.newInstance();
        loadedClass.getConstructor(Integer.class).newInstance(1);
        loadedClass.getMethod("m", Integer.class).invoke(1);
        //FEST-reflect
        loadedClass.getAnnotations();
        loadedClass.getTypeParameters();

        mmmmmmm();
    }

    @Deprecated
    private static void mmmmmmm() {
        new Date(1,1,2017);
    }
}

class Super {
    void m() {}
}

class Sub extends Super {
    @Override
    void m() {
        super.m();
    }
}