//package com.acme.edu.iteration03;
//
//import com.acme.edu.ooad.Logger;
//import com.acme.edu.SysoutCaptureAndAssertionAbility;
//import org.junit.jupiter.api.*;
//import java.io.IOException;
//import static com.acme.edu.OldLogger.STRING_PREFIX;
//
//public class LoggerTest implements SysoutCaptureAndAssertionAbility {
//    //region given
//    @BeforeEach
//    public void setUpSystemOut() throws IOException {
//        resetOut();
//        captureSysout();
//    }
//
//    @AfterEach
//    public void tearDown() {
//        resetOut();
//    }
//    //endregion
//
//    /*
//    TODO: implement Logger solution to match specification as tests
//    */
//
//    @Disabled
//    @Test
//    public void shouldLogStringsWithOneMethodCall() throws IOException {
//        //region when
//        Logger.log("str1", "string 2", "str 3");
//        Logger.flush();
//        //endregion
//
//        //region then
//        assertSysoutContains(STRING_PREFIX + "str1" + System.lineSeparator() +
//                            STRING_PREFIX +  "string 2"  + System.lineSeparator() +
//                            STRING_PREFIX +   "str 3"  + System.lineSeparator()
//        );
//        //endregion
//    }
//    @Disabled
//    @Test
//    public void shouldLogIntegersWithOneMethodCall() throws IOException {
//        //region when
//        Logger.log(-1, 0, 1, 3);
//        Logger.flush();
//        //endregion
//
//        //region then
//        assertSysoutContains("3");
//        //endregion
//    }
//}
