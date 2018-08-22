package controllingexecution;

public class CyclesAndBranchesDemo {
    public static void main(String[] args) {
        String s = ""; //null
        switch (s) {
            case "a":
                System.out.println("1");
                break;
            case "b":
                System.out.println("2");
                break;
            default:
                System.out.println("?????");
        }
    }
}
