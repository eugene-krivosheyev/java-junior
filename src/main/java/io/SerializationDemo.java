package io;

import java.io.*;

/**
 * -> binary serialization with interoperability: Apache Thrift, Google Protobuf
 * -> text serialization: XML+XSD+XPath+XSLT, JSON (Jackson, Gson)
 */
public class SerializationDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("obj.ser"))))  {

            out.writeObject(new Cat("1"));
            out.writeObject(new Cat("2"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("obj.ser")
                )
        )) {

            System.out.println(((Cat)in.readObject()).getName());
            System.out.println(((Cat)in.readObject()).getName());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Cat implements Serializable {
    private String name;
    transient private int id;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
