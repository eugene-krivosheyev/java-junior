package demo.tm;

public class IntMessage extends DecoratingMessage {
    @Override
    protected void step() {
        System.out.println("111");
    }
}
