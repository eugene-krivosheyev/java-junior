package com.acme.edu.iteration02;


import com.acme.edu.Logger;
import com.acme.edu.Printer;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    private static final String SEP = System.lineSeparator();
    private Logger logger;

    //region given
    @Before
    public void setUpSystemOut(){
        logger = new Logger(new Printer());
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion


    @Test
    public void shouldLogSequentIntegersAsSum() {
        //region when
        logger.log("str 1");
        logger.log(1);
        logger.log(2);
        logger.log("str 2");
        logger.log(0);
        logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
                "string: str 1" + SEP +
                        "primitive: 3" + SEP +
                        "string: str 2" + SEP +
                        "primitive: 0" + SEP
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        logger.log("str 1");
        logger.log(10);
        logger.log(Integer.MAX_VALUE);
        logger.log("str 2");
        logger.log(0);
        logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
                "string: str 1" + SEP +
                        "primitive: 10" + SEP +
                        "primitive: " + Integer.MAX_VALUE + SEP +
                        "string: str 2" + SEP +
                        "primitive: 0" + SEP
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenPreviousInteger() {
        //region when
        logger.log("str 1");
        logger.log(-10);
        logger.log(Integer.MIN_VALUE);
        logger.log("str 2");
        logger.log(0);
        logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
                "string: str 1" + SEP +
                        "primitive: -10" + SEP +
                        "primitive: " + Integer.MIN_VALUE + SEP +
                        "string: str 2" + SEP +
                        "primitive: 0" + SEP
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() {
        //region when
        logger.log("str 1");
        logger.log("str 2");
        logger.log("str 2");
        logger.log(0);
        logger.log("str 2");
        logger.log("str 3");
        logger.log("str 3");
        logger.log("str 3");
        logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + SEP +
            "string: str 2 (x2)" + SEP +
            "primitive: 0" + SEP +
            "string: str 2" + SEP +
            "string: str 3 (x3)"+ SEP
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutMultiRepeat(){
        //region when
        logger.log("");
        logger.log("str 2");
        logger.log("str 2");
        logger.log("str 3");
        logger.log("str 2");
        logger.log(1);
        logger.log(2);
        logger.log(4);
        logger.log(8);
        logger.log(16);
        logger.log("str 2");
        logger.log(0);
        logger.log("str 2");
        logger.log("str 3");
        logger.log("str 3");
        logger.log("str 3");
        logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
                        "string: str 2 (x2)" + SEP +
                        "string: str 3" + SEP +
                        "string: str 2" + SEP +
                        "primitive: 31" + SEP +
                        "string: str 2" + SEP +
                        "primitive: 0" + SEP +
                        "string: str 2" + SEP +
                        "string: str 3 (x3)" + SEP
        );
    }
}