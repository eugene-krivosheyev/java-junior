package demo.tm;

public class ByteMessage extends DecoratingMessage {
    @Override
    protected void step() {
        System.out.println("222");
    }
}
