package com.acme.edu;

import java.io.IOException;
import java.util.function.BiConsumer;

public class SysLibDemo {
    public static void main(String[] args) {
        System.nanoTime();
        System.currentTimeMillis();
        System.getProperties().forEach((s, s2) -> System.out.println(s + ":" + s2));
        System.gc();
//        System.arraycopy(); //JNI -> JNA
//        System.loadLibrary();
        Runtime.getRuntime();
        Math.abs(0);

        Cat cat1 = new Cat("a", 1);
        try {
            Object cat2 = cat1.clone();
            System.out.println(cat2);
            cat1.setId(5);
            System.out.println(cat1);
            System.out.println(cat2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Integer i = 1;
        int ii = i;
        for (Integer iii = 0; iii < 10; iii++) {

        }

        Integer t1 = 128;
        Integer t2 = 128;
        System.out.println(t1 == t2); //intern or not intern
    }
}

class Cat implements Cloneable {
    private String name;
    private int id;

    public Cat(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (id != cat.id) return false;
        return name != null ? name.equals(cat.name) : cat.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
