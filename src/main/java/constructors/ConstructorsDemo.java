package constructors;

public class ConstructorsDemo {
    public static void main(String[] args) {
        Animal cat = new Cat("cat");
        Animal sp = new Sphinx("");
        System.out.println(cat.getName());
    }
}

class Animal extends Object {
    private String name = null;

    {
        System.out.println("init block 1");
        String name;
    }

    Animal(String name) {
        System.out.println("constr");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    {
        System.out.println("init block 2");
        System.out.println(this.name);
    }
}

class Cat extends Animal {
    Cat(String name) {
       super(name);
    }
}

class Sphinx extends Cat {
    Sphinx() {
        super("лысая");
    }
}
