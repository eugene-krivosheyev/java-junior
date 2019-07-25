package com.acme.edu.io;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        try (final ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("demo.ser")))) {

            out.writeObject(new Cow(1, "Burenka"));
            out.writeObject(new Cow(2, "Dus'ka"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (final ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("demo.ser")))) {

            try {
                while (true) {
                    Object readObject = in.readObject();
                    if (readObject instanceof Cow) {
                        Cow readCow = (Cow) readObject;
                        System.out.println(readCow.getId() + ":" + readCow.getName());
                    }
                }
            } catch (EOFException e) { }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Cow implements Serializable {
    private int id;
    private String name;
    private transient String noToSer = "qqq";

    public Cow(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
