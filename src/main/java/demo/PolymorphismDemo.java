package demo;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Object o = new Insure(); // new -> creational components
        System.out.println(o.toString());


    }
}

class Insure {
    @Override
    public String toString() {
        return "Я же говорил!!!!!";
    }
}