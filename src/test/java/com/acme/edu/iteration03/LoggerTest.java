package com.acme.edu.iteration03;

//import com.acme.edu.Logger;
import com.acme.edu.ooad.controller.LoggerController;
import com.acme.edu.ooad.factory.LoggerControllerFactory;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.*;
import java.io.IOException;
import static com.acme.edu.Logger.STRING_PREFIX;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @BeforeEach
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }
    //endregion

    /*
    TODO: implement Logger solution to match specification as tests
    */

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {

        LoggerController logger = LoggerControllerFactory.create();

        //region when
        logger.log("str1", "string 2", "str 3");
        logger.flush();
        //endregion

        //region then
        assertSysoutContains(STRING_PREFIX + "str1" + System.lineSeparator() +
                            STRING_PREFIX +  "string 2"  + System.lineSeparator() +
                            STRING_PREFIX +   "str 3"  + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {

        LoggerController logger = LoggerControllerFactory.create();

        //region when
        logger.log(-1, 0, 1, 3);
        logger.flush();
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }
}
