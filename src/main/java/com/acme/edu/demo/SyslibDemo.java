package com.acme.edu.demo;

import java.io.IOException;
import java.util.Date; //nope!
import java.time.Instant; //joda time - yep!
import java.util.Properties;

public class SyslibDemo {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        System.currentTimeMillis(); //epoch
        System.nanoTime();

        System.gc();

        //Properties = Map<String, String>
        final Properties properties = System.getProperties();
        properties.list(System.out);
        properties.getProperty("file.encoding");
        // java -Dfile.encoding=cp866 -Dk=v -cp my.jar MyClass "prog args"

//        System.arraycopy();
//        System.load(""); //loadLibrary() //JNI -> JNA -> ???

        final Runtime runtime = Runtime.getRuntime();
//        runtime.exec("rm -rf /");
        runtime.availableProcessors();
        runtime.addShutdownHook(new Thread(() -> System.out.println("bye!")));

        System.out.println(new Object());

        final Geeraff burzum = new Geeraff("burzum", 1);
        final Geeraff mgla = burzum.clone();
        System.out.println(mgla);

    }
}

class Geeraff extends Object implements Cloneable {
    private String name;
    private int age;
    private Geeraff theFriend; //Shallow default cloning

    public Geeraff(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("!!!");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public Geeraff clone() throws CloneNotSupportedException {
        return (Geeraff) super.clone();
    }

    @Override
    public String toString() {
        return "Geeraff {" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
