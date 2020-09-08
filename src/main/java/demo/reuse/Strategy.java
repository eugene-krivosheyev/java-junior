package demo.reuse;

public interface Strategy {
    public static final int GLOBAL_CONST = 0;
    public static void step(int p) {
        System.out.println("sss");
    }

    public default void step(String p) {
        this.setName();
    }

    void setName();
}

class StrImpl3 implements Strategy {
    @Override
    public void step(String p) {

    }

    @Override
    public void setName() {
        ///////
    }
}