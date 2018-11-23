package demo.math;

public class MathDemo {
    public static void main(String[] args) {
        try {
            Math.addExact(1, 2);
        } catch (ArithmeticException e) {
            //overflow detected!!!
        }
    }
}
