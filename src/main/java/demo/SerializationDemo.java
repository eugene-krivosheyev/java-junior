package demo;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        final var message = new Message(1, "body");

        try (final ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("objects.data")))) {

            objOut.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (var in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("objects.data")))) {

            final Object objIn = in.readObject();
            var obj = (Message)objIn;
            System.out.println(" >>>>>> " + obj);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

//POJO
class Message implements Serializable {
    transient private int id;
    private String body;

    public Message(int id, String body) {
        this.id = id;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Message: {" +
                "id=" + id +
                ", body='" + body + '\'' +
                '}';
    }
}