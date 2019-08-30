package com.acme.edu.demo;

import java.io.*;

/**
 * -> B-SON, Apache Thrift, Google Protobuf
 */
public class SerializationDemo {
    public static void main(String[] args) {
        try (final ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(
                    new FileOutputStream("objects.ser")))) {

            out.writeObject(new Behemoth("1"));
            out.writeObject(new Behemoth("2"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (final ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(
                    new FileInputStream("objects.ser")))) {

            System.out.println(in.readObject());
            System.out.println(in.readObject());
            System.out.println(in.readObject());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Behemoth implements Serializable {
    private String name;
    private transient int temporalId;

    public Behemoth(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Behemoth{" +
                "name='" + name + '\'' +
                ", temporalId=" + temporalId +
                '}';
    }
}
