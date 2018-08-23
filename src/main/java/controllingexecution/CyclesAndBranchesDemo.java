package controllingexecution;

public class CyclesAndBranchesDemo {
    /**
     * $> java -Xmx6G MyClass a b cd "ef gh"
     */
    public static void main(String[] args) {
        for (String current : args) {
            System.out.println("> " + current);
        }

        outer: do {
            inner: while (true) {
                break inner;
//                continue outer;
            }
        } while (true);
    }
}
