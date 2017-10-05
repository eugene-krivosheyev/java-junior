package demo;

public class ObjectDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Object o = new Object();
        System.out.println(new int[] {}); //[I@4864

        System.out.println(o == o); //Same
//        Object.class //
//        o.getClass()
//        new Cat().equals(new SuperCat());
//        new Cat().equals(???)

        Object o2 = new Object();
        o2.clone();

        SuperCat cat1 = new SuperCat();
        SuperCat cat2 = (SuperCat) cat1.clone();
    }
}

class Cat extends Object {
    private String name;
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (id != cat.id) return false;
        return name != null ? name.equals(cat.name) : cat.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

}

//Shallow | Deep
class SuperCat extends Cat implements Cloneable {
    @Override
    public SuperCat clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
