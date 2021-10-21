package demo.tm;

public class Message {
    private Strategy stepExecutor;

    public Message(Strategy stepExecutor) {
        this.stepExecutor = stepExecutor;
    }

    public void getDecoratedMessage() {
        //....
        //....
        stepExecutor.step();
        //....
        //....
    }

}
