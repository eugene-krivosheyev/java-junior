package inheritancedemo;

public class Demo {
    public static void main(String[] args) {

    }
}

class ???Message {
    private final int type = 1;

    public boolean isSameType(Message m) {
        return m instanceof this;
    }
}

class IntMessage {
    private final int type = 2;
}
