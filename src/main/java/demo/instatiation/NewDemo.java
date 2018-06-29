package demo.instatiation;

public class NewDemo {
    public static void main(String[] args) {
        new Data();
    }
}

class Data extends Object {
    private int field = 0;

    Data(int field) {
        super();
        this.field = field;
    }

    /*
    Data() {
        this(5); //|| super();
    }
    */
}

class SuperData extends Data {
    SuperData(int field) {
        super(field);
        System.out.println("");
    }
}
