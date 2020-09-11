package demo;

import java.io.IOException;
import java.util.Properties;

import static java.lang.Math.round;
import static java.lang.System.getProperty;

public class SystemLibraryDemo {
    public static void main(String[] args) {
//        System.out;
//        System.err;
//        System.in;
//        System.exit(0);
        System.currentTimeMillis();
        System.nanoTime();
//        System.arraycopy();
        System.lineSeparator();

        System.getProperties().keySet()
                .forEach(key -> System.out.println(key + " : " + getProperty((String)key)));

        System.gc();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
//                ????
            }
        });
        try {
            Runtime.getRuntime().exec("ls").waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        Runtime.getRuntime().availableProcessors();

        Math.random();

        try {
            final Message cloned = (Message)new Message(1).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class Message implements Cloneable {
    private int id;
    private String str;

    Message(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
//        if (o == null || o instanceof Message) ???

        Message message = (Message) o;

        if (getId() != message.getId()) return false;
        return str != null ? str.equals(message.str) : message.str == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (str != null ? str.hashCode() : 0);
        return result;
    }
}
