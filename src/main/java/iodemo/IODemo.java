package iodemo;

import java.io.*;
import java.util.Locale;

public class IODemo {
    public static void main(String[] args) {
        File file = new File("." + File.separator + "test.txt");

        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(
                new BufferedInputStream(
                    new FileInputStream(file)), "UTF-8"))) {

            String readLine;
            while ((readLine = br.readLine()) != null) {
                System.out.println(readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //region Serialization
        try (ObjectOutputStream out = new ObjectOutputStream(
            new BufferedOutputStream(
                new FileOutputStream("objects.ser", true)))) {

            out.writeObject(new Cat("murik"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(
            new BufferedInputStream(
                new FileInputStream("objects.ser")))) {

            System.out.println(">>>>" + ((Cat)in.readObject()).getName());

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
    private final String name;
    private transient Mood mood = new Mood();

    Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Mood {

}
