package inner;

public class InnerClassesDemo {
    private static int classState;
    private int instanceState;

    private Flyable getCommand() {
        int localVar = 0;

        /*
        return new Flyable() {
            @Override
            public void fly() {
                System.out.println(classState);
                System.out.println(InnerClassesDemo.this.instanceState);
                System.out.println(localVar);
            }
        };
        */
        return () -> {
            System.out.println(classState);
            System.out.println(InnerClassesDemo.this.instanceState);
            System.out.println(localVar);
        };
    }

    public static void main(String[] args) {
        Flyable object = new InnerClassesDemo().getCommand();
        //?????
        object.fly();
    }
}

@FunctionalInterface
interface Flyable {
    void fly();
}

class MyRegistry {
    public static void register(Flyable object) {
        object.fly(); //in parallel
    }
}
