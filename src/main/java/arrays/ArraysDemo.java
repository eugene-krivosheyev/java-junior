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
    }

    private static void m(int[] param) {

    }
}
