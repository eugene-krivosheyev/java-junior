package arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] array = new int[10_000];
        System.out.println(array[0]);
        for (int current : array) {
            current = 1;
        }
        System.out.println(array[0]);

        int[][] matrix = new int[5][];

        int[] hardcodedArray = {1,2,3};
        int[] hardcodedArray2 = {1,2,3};

        m(new int[] {1,2,3});

//        varargm(1, 11, 12);
    }

    private static void m(int[] param) {

    }
    private static void varargm(int... p) {}

    private static void varargm(int p, int... param) {
        for (int current : param) {
            System.out.println(current);
        }
    }
}
