package demo.proceduraltoooad;

public class IntMessage {
    private int message;

    public IntMessage(int message) {
        this.message = message;
    }


    public String getDecoratedMessage() {
        return "PRIMITIVE: " + this.message;
    }
}
