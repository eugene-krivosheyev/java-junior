package demo;

public class PrimitivesDemo {
    public static void main(String[] args) {
        Cat cat = new Cat(0);
        Cat cat2 = cat;
        System.out.println(Cat.catsCount);
    }
}

class Cat {
    public static int catsCount;

    private int id;
    private Cat friend;

    public Cat(int id) {
        this.id = id;
    }
}