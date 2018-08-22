package overloading;

public class OverloadingDemo {
    public static void main(String[] args) {
        printing(1);
    }
    public static void printing(int i) {
        System.out.println(i);
    }
    public static void printing(String s) {
        System.out.println(s);
    }

}
