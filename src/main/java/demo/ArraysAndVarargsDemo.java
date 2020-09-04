package demo;

public class ArraysAndVarargsDemo {
    public static void main(String... args) {
        /**
         * Guard clauses
         */
        if (args.length == 0) throw new IllegalArgumentException("pr args needed!");
        for (String currentPrArg : args) {
            System.out.println(currentPrArg);
        }

        int[] intArray = new int[0];
        intArray[0] = 1;
        System.out.println(intArray[9]);
        System.out.println(intArray.length);

        int[][] matrix = new int[10][];
        System.out.println(matrix[0]);

        int[] hardcodedArray = {1,2,0};
        doSmthWithArray(new int[] {1,2});
        doSmthWithVararg(1);
    }

    private static void doSmthWithArray(int[] param) {
        for (int current : param) {
            System.out.println(current);
        }
    }

    private static void doSmthWithVararg(String param, int... args) {
        for (int current : args) {
            System.out.println(">>" + current);
        }
    }
}

