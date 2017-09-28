package demo;

public class ControllingExecution {
    public static void main(String[] args) {
        //Guard Clause for alternate flows
        if (false) throw new RuntimeException();
        if (false) throw new RuntimeException();
        if (false) throw new RuntimeException();
        if (false) throw new RuntimeException();

        //main flow
        boolean isWritable = a && isWritable;
        boolean isAccessible = !c;
        boolean isAllowed = isWritable || isAccessible;

        if (args.length > 0) {
            System.out.println("have args");
        } else {
            if (isAllowed) {
                return 1; //result = 1;
            } else if (false) {
                return 2;
            } else {
                return 3;
            }
        }
        return result;

        String i = "q";
        switch (i) {
            case "0":
                saveToFile("1");
                break;
            case "1":
                saveToDb();
                break;
            default:
                System.out.println("!!!");
        }

        for (int j = 0, c = 1; j < 10 && c > 2; j++, c++) {

        }

        //10 ksloc
        //Cyclomatic complexity: 2.5
        outer: do {
            inner: while (true) {
                break inner;
                continue outer;
            }
        } while (true);

        while (true) {
            //....
            if (isIterationDone) continue;
            if (isDone) break;
        }

        for (String arg : args) {
            System.out.println(arg);
        }



















        if (isOk) {
            //main flow
            //main flow
            //main flow
            //main flow
        } else if (alt1) {
            //alt flow
        } else if (alt2) {

        }
    }

    private static void saveToFile(String x) {
        System.out.println(x);
    }

    private static void saveToDb() {
        System.out.println("2");
        System.out.println("2");
    }

    private static int m() {
        return 1;
    }
}
