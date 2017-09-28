package demo;

public class ArraysDemo {
    public static void main(String[] args) {
        Cat[] catArray = new Cat[5];
//        catArray[0] = 0;
//        catArray.length
//        System.arraycopy();
        for (Cat element : catArray) {

        }

        int[] intArray = {1,2,3,4};
        Cat[] catArray2 = {
                new Cat(0),
                new Cat(1)
        };

        loveAllCats(new Cat[] {
                new Cat(0),
                new Cat(1)
        });
        //m(new int[] {1,2,3});


        int[][] matrix = new int[5][4];
        matrix[0][1] = 0;
        int[][] literalMatrix = {
                {1,2},
                {},
                {1,2,4,5},
                null,
                {}
        };

        int[] nullarray = null;
        nullarray.length; //NPE
    }

    private static void loveAllCats(Cat[] catsToLove) {

    }
}
