package demo.finalandenumdemo;

public class FinalAndEnumDemo {
    private static final int classield; //Blank final class field
    private final int field; //Blank final object field

    static {
        classield = 0;
    }

    public FinalAndEnumDemo(int field) {
        this.field = field;
    }

    public static void main(String[] args) {
        final Cat theCat = new SuperCat("Tom");
        //Not immutable!
//        theCat.setName();
        theCat.getName()
    }
}

final class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }
}

class SuperCat extends Cat {
    public SuperCat(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return "Super " + super.getName();
    }
}
