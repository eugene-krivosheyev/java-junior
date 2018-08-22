package operators;

import java.util.Objects;

public class OperatorsDemo {
    public static strictfp void main(String[] args) {
        System.out.println(b1() || b2());
    }

    private static boolean b1() {
        return false;
    }

    private static boolean b2() {
        return false;
    }
}
