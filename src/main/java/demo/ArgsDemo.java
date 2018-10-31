package demo;

public class ArgsDemo {
    static int globalState = 0;
    int objectState;
    static DataHolder globalState2 = new DataHolder(0);

    public static void main(String[] args) {
        //final = const
        final int constVar = 0;
        final DataHolder dataHolder = new DataHolder(1);
        m(dataHolder); //OUT param
        System.out.println(dataHolder);
        globalState2.getData();
    }

    private static void m(final DataHolder param) {
        int localVar = 0;
        System.out.println(localVar);

        param.setData(2);
        System.out.println(param);

        int i = 0;
        System.out.println(i);

    }
}

class DataHolder {
    private int data;

    public DataHolder(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    /**
     * Mutable
     */
    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }
}
