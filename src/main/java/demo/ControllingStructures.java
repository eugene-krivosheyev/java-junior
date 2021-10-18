package demo;

public class ControllingStructures {
    public static void main(String[] args) {
        //region branches
        int result = args.length > 0 ? 1 : 0;
        if (args.length > 0) {

        } else if(false) {

        } else {

        }

        String input = null; // "a" == "a"; "a".equals("a"); Objects.equals("a","a")
        switch (input) {
            case "a": System.out.print("0"); break;
            case "1": System.out.print("1"); break;
            case "5": System.out.print("too much!");
            default: System.out.println("else");
        }
        //endregion

        //region loops
        for (int counter = 0, j = 0; counter < 10 & j < 5; counter++) {

        }

        int counter = 0;
        outer: while (counter++ < 10) {
            inner: do {
//                if (???) continue outer; // break
                //...
            } while (counter++ < 10);
            //...
        }
        //....

        // Iterating over array or Iterable
        for (String current : args) {
            System.out.println(current);
        }
        //endregion
    }

    private static void doSmth(String arg) {
        if (arg != null && !arg.isEmpty()) {
            // main flow
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Refactoring: Introduce Guard clauses
     */
    private static void doSmth2(String arg) {
        if (arg == null || arg.isEmpty()) throw new IllegalArgumentException();

        //main flow:
        //
        //
        //
        //
    }

    public static String choose(int arg) {
        return arg > 0 ? "first" : "second";
    }
}
