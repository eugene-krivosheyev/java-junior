package ooaddemo;

/**
 * @since 1998
 */
public interface LoggerFilter {
    int MY_SUPERCONST = 0;
    boolean filter(String message);

    static void m() {
        System.out.println("");
    }

    default void m2() {
    }

}
