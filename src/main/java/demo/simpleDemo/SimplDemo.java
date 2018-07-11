package demo.simpleDemo;

public class SimplDemo {
    private int state;


    public SimplDemo(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public static void main(String[] args) {
        new SimplDemo(2).getState();
    }
}
