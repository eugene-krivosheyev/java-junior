package demo;

public class FinalDemo {
    public static final String MY_CONST;
    public final String objectConst; //blank final

    static {
        MY_CONST = "1";
    }

    public FinalDemo() {
        this.objectConst = "objectConst";
    }

    public static void main(final String[] args) {
        final int intConst = 1;
        //intConst++;
    }
}

final class NotInheritable {
    public final void m() {

    }
}
