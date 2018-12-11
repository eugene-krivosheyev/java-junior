package demo.proceduraltoooad;

public class IntMessage {
    private int message;

    public IntMessage(int message) {
        //0.
        //1. {}
        this.message = message;
        System.out.println("1");
    }

    public IntMessage() {
        System.out.println("3");
    }

    {
        System.out.println("2");
    }

    {
        System.out.println("3");
    }


    public String getDecoratedMessage() {
        return "PRIMITIVE: " + this.message;
    }
}
