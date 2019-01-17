package demo.iodemo;

import java.io.*;
import java.util.Date;

public class IODemo {
    public static void main(String[] args) {
        File file = new File("test.txt"); //Path responsibility

        //Writing:
        try (ObjectOutputStream out = new ObjectOutputStream(
                    new BufferedOutputStream(
                        new FileOutputStream(file)))) {

            out.writeObject(new Cat("1"));
            out.writeObject(new Cat("2"));

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)))) {

            Cat cat = null;
            while ( (cat = (Cat) in.readObject()) != null) {
                System.out.println(">>> " + cat);
            }

        } catch (EOFException e) {

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

//JAXP API: SAX + DOM
//JAXB API: XSD <-> class, xml <-> obj

//obj <-> json: GSON, Jackson
class Cat implements Serializable {
//    private static long serialVerId = 0L;

    private String name;
//    @JsonIgnore
    private transient Date smth;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat {" +
                "name='" + name + '\'' +
                '}';
    }
}
