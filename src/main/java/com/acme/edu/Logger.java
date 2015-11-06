package com.acme.edu;

import java.util.Comparator;

public class Logger {
    private int i;

    public Comparator m(int param) {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                i = 8;
                System.out.println(param);
                return 0;
            }
        };
    }

    public void log(String message) {
        assert message != null : "djfdjfhgdfjhg"; //throw new AssertionError("fff")
        System.out.println(message);
    }

    @Override
    public String toString() {
        return "gggg";
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}

class Message implements Cloneable {
    private String value;
    private int index;


    Message(String value) {
        this.value = value;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        if (index != message.index) return false;
        return value.equals(message.value);

    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + index;
        return result;
    }
}

class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
//        System.out.println(new Message("test").clone());
//        System.out.println((new Message("")).equals(new Message("")));
//        StringBuffer s = new StringBuffer("D");
//        s.append("ffff");

        Integer i1 = -129;
        Integer i2 = -129;
        System.out.println(i1.equals(i2));

        mm(3);
    }

    private static void mm(byte i) {}
    private static void mm(Integer i) {}
}







