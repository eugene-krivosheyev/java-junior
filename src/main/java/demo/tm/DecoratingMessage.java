package demo.tm;

/**
 * [GoF] Template Method
 */
public abstract class DecoratingMessage {
    public void getDecoratedMessage() {
        //....
        //....
        this.step();
        //....
        //....
    }

    protected abstract void step();
}
