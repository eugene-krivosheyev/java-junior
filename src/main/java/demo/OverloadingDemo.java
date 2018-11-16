package demo;

public class OverloadingDemo {
    public static void main(String[] args) {
        Calc.add(0); //auto-boxing
        double d = 0L; //IEEE 754

        System.out.println(1 + "2");
    }
}

class Calc {
    public static double add(double a) {
        return 0;
    }
}
