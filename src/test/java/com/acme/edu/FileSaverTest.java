package com.acme.edu;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by kate-c on 30/08/2019.
 */
public class FileSaverTest {

    @Test
    public void shouldLog() throws IOException {
        //region when
        Logger.log(1);Logger.flush();
        Logger.log(2);Logger.flush();
        Logger.log(3);Logger.flush();
        Logger.log(4);Logger.flush();
        Logger.log(5);Logger.flush();
        Logger.log(6);Logger.flush();
        Logger.log(7);Logger.flush();
        Logger.log(8);Logger.flush();
        Logger.log(9);Logger.flush();
        Logger.log(10);Logger.flush();
        Logger.log(11);Logger.flush();
        //endregion
    }
}
