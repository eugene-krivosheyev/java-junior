package com.acme.edu.demo;

import java.io.IOException;
import java.util.Date; //nope!
import java.time.Instant; //joda time - yep!
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Geeraff geeraff = (Geeraff) o;

        if (age != geeraff.age) return false;
        if (!Objects.equals(name, geeraff.name)) return false;
        return Objects.equals(theFriend, geeraff.theFriend);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (theFriend != null ? theFriend.hashCode() : 0);
        return result;
    }
}
