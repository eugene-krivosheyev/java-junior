package com.acme.edu.io;

import java.io.*;

public class IODemo {
    public static void main(String[] args) {
        File f = new File("test.txt"); //NIO2 -> Path
        File f2 = new File(f, "test2");

//        Scanner;

        File file = new File("cats.txt");

        try (ObjectOutputStream out = new ObjectOutputStream(
                    new BufferedOutputStream(
                        new FileOutputStream(file, true)))) {

            out.writeObject(new NewCat("murik", 7));
            out.writeObject(new NewCat("murik2", 8));

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream in = new ObjectInputStream(
                    new BufferedInputStream(
                        new FileInputStream(file)))) {

            System.out.println(in.readObject());
            System.out.println(in.readObject());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

class NewCat implements Serializable {
    static long serialVersionUID = 1L;

    private String name;
    transient private int age;

    NewCat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "NewCat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/**
 * -> JAXB, JsonMappers: GSON, Jackson -> JSR: json-java mappers
 */
class NewNewCat implements Externalizable {

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}