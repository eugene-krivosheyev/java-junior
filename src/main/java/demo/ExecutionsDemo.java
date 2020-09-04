package demo;

public class ExecutionsDemo {
    public static void main(String[] args) {
        //region Gurad clauses
        if (args.length == 0) throw new IllegalArgumentException("args needed!");
        if (args.length == 0) throw new IllegalArgumentException("args needed!");
        if (args.length == 0) throw new IllegalArgumentException("args needed!");
        //endregion

        //region if
        if (true) {

        } else if (false) {

        }

        if (args.length > 0) {
            //......
        } else {
            System.out.println("args needed!");
        }
        //endregion

        //region switch
        String i = "1";
        switch (i) {
            case "1" + "1": System.out.println("1");
            case "2": System.out.println("2");
            default: System.out.println("n/a");
        }
        while (true) {
            System.out.println("");
        }
        //endregion

//        for (;;) {}
        /*
        for (int counter = 0, j = 1; counter < 10; counter++, j--) {

        }
        */
        /*
        do {
            if (???) break;
            if (???) continue;
                ///
        } while (1 != 1);

        outer: while(true) {
            while() {
                for () {
                    if (??) break outer;
                    if (??) continue outer;
                }
            }
        }

        for (String current : args) {
            System.out.println(current);
        }
        */
    }

    String m() {
        return "2";
    }
}
