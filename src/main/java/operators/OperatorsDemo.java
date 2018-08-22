package operators;

public class OperatorsDemo {
    public static void main(String[] args) {
        byte accumulator = Byte.MIN_VALUE;
        for (int counter = 0; counter < 258; counter++) {
            accumulator++;
        }
        System.out.println(accumulator);
    }
}
