package com.db.edu.iteration03;

import com.db.edu.Logger;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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

    /* deprecated - use varargs call instead
    @Test
    public void shouldLogIntegersArray() throws IOException {
        //region when
        Logger.log(new int[] {-1, 0, 1});
        Logger.flush();
        //endregion
        //region then
        assertSysoutEquals(
            "primitives array: {-1, 0, 1}" + System.lineSeparator()
        );
        //endregion
    }
    */
    /*
    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        Logger.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        //endregion
        //region then
        assertSysoutEquals(
            "primitives matrix: {\n" +
                "{-1, 0, 1}\n" +
                "{1, 2, 3}\n" +
                "{-1, -2, -3}\n" +
            "}\n"
        );
        //endregion
    }
    */
    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        Logger.log("str1", "string 2", "str 3");
        Logger.flush();
        //endregion
        //region then
        String ls = System.lineSeparator();
        assertSysoutEquals("string: str1" + ls + "string: string 2" + ls + "string: str 3" + ls);
        //endregion
    }
    @Test
    public void shouldLogSameStringWithOneMethodCall() throws IOException {
        //region when
        Logger.log("str1", "string 2", "string 2", "str 3", "string 2");
        Logger.flush();
        //endregion
        //region then
        String ls = System.lineSeparator();
        assertSysoutEquals("string: str1" + ls + "string: string 2 (x2)"
                + ls + "string: str 3" + ls + "string: string 2" + ls);
        //endregion
    }
    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        Logger.log(-1, 0, 1, 3);
        Logger.flush();
        //endregion
        //region then
        assertSysoutEquals("primitive: 3" + System.lineSeparator());
        //endregion
    }
    @Test
    public void shouldLogIntegerOverflowWithOneMethodCall() throws IOException {
        //region when
        Logger.log(-1, 0, Integer.MAX_VALUE, 3, 1, 3);
        Logger.flush();
        //endregion
        //region then
        String ls = System.lineSeparator();
        assertSysoutEquals("positive overflow: " + Integer.MAX_VALUE + ls + "primitive: 6" + ls);
        //endregion
    }
}