package demo;

public class ControllingDemo {
    public static void main(String[] args) {
        //region guard clauses:
        if (1 == 0) return;
        if (1 == 0) throw new RuntimeException("");
        //endregion

        //region switching
        String s = 1 == 1 ? "1" : "2";

        if (1 == 1 && 0 != 1) {
            System.out.println("fff");
        } else if (1 != 1) {

        } else {

        }

        int var = 5;
        switch (var) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("any other");
        }
        //endregion

        //region cycles
        outrr: for (int counter = 0, i = 1; counter <= Integer.MAX_VALUE+5 && i > 0; counter++, i--) {
            for (int j = 0; j < 10; j++) {
                continue;
            }
//            continue;
            //sdfkjsf
        }
        //ksloc
        //cyclomatic complexity: overall / cc per method

        outer: while (1 != 0) {
            inner: do {
                if (1 == 0) break outer;
            } while (!(1 != 0));

            if (1 != 9) continue;
            //not to run
        }
        //ldfjvldkgj

        for (;;) {}
        //endregion




    }
}
