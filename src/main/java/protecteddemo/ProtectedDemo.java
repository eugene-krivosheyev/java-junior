package protecteddemo;

public class ProtectedDemo {
    public static void main(String[] args) {
        MainAlgorithm todo = new OpOnMainAlgorithm();
        todo.decoratedExec();
    }
}

/**
 * Template Method [GoF]
 */
abstract class MainAlgorithm {
    public void decoratedExec() {
        System.out.println(">>>>>");
        op(); //step
        System.out.println("<<<<<");
    }

    protected abstract void op();
}

class OpOnMainAlgorithm extends MainAlgorithm {
    @Override
    protected void op() {
        System.out.println("OOOOOPPPPP");
    }
}