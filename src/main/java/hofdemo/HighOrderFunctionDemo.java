package hofdemo;

public class HighOrderFunctionDemo {
    public static int flush1() {
        return tryOperationOrReturn(
            () -> System.out.println("1"),
            100
        );
    }

    public static int flush2() {
        return tryOperationOrReturn(
            () -> System.out.println("2"),
            200
        );
    }

    public static int tryOperationOrReturn(FunctionVoidVoid todo, int code) {
        try {
            todo.call();
        } catch (Exception e) {
            return code;
        }
        return 0;
    }
}

interface FunctionVoidVoid {
    void call();
}
