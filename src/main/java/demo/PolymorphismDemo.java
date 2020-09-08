package demo;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Object o = new Insure(); // new -> creational components
        System.out.println(o.toString());

        Object[] array = {
                new String("abc"),
                new Double("4.0"),
                new Insure()
        };
        for (Object current : array) {
            System.out.println(current.toString());
        }
    }
}

class Insure {
    @Override
    public String toString() {
        return "AAAAA!!!!! Осень!!!!!!";
    }
}