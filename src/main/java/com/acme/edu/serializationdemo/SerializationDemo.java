package com.acme.edu.serializationdemo;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        File target = new File("target", "objects.ser");

        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {

            out.writeObject(new Cat("11", 1));
            out.writeObject(new Cat("22", 2));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(target))
        )) {

            Cat cat1 = (Cat) in.readObject();
            System.out.println(cat1.getId() + " " + cat1.getName());
            Cat cat2 = (Cat) in.readObject();
            System.out.println(cat2.getId() + " " + cat2.getName());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Cat implements Serializable {
    private String name;
    private transient int id;

    public Cat(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}