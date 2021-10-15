package demo;

public class ArraysDemo {
    public static void main(String... args) {
        int[] array = new int[10]; //Collections API
        System.out.println(array[0]);
        array[0] = 1;

        System.out.println(array.length);
        for (int current : array) {

        }

        Object[] arr = new Object[10];

        int[][] matrix = new int[10][];
        matrix[0] = new int[1];
        matrix[1] = new int[2];

        int[] hardcoded = {2, 5, 6, 7};
        m(hardcoded);

        m(new int[] {1,3});

        mWithVararg();
        mWithVararg(new int[] {1,3});
        mWithVararg(1,2);
        mWithVararg(1,2,3,4,5,6,7,8);
    }

    private static void m(int[] arg) {
        for (int current : arg) {
            System.out.println(current);
        }
    }

    private static void mWithVararg(int... arg) {
        int first = arg[0];
        for (int current : arg) {
            System.out.println(arg);
        }
    }
}
