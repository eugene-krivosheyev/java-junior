package demo;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        try (final ObjectOutputStream out =
                 new ObjectOutputStream(
                    new BufferedOutputStream(
                        new FileOutputStream("objects.data")))) {

            out.writeObject(new Surikat(1, "sharik"));
            out.writeObject(new Surikat(2, "bobik"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * Binary serialization suxx
 * XML and JSON serialization rulezzzz
 * JAXB and Gson|Jackson
 * Thrift | Protobuf
 *
 */
class Surikat implements Serializable {
    private int id;
    transient private String name;

    public Surikat(int id, String name) {
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