package demo.instatiation;

public class NewDemo {
    public static void main(String[] args) {
        new Data(1);
    }
}

class DataSuper {
    public DataSuper() {
        System.out.println("DataSuper");
    }
}
class Data extends DataSuper {
    private int field = 0;

    {
        System.out.println("init block");
    }

    Data(int field) {
//        super();
        System.out.println("Data");
        this.field = field;
    }


    Data() {
        this(5); //|| super();
    }

}

class SuperData extends Data {
    SuperData(int field) {
        super(field);
        System.out.println("");
    }
}

class Demo {
    public static void main(String[] args) {
        new Data(0);
    }
}
