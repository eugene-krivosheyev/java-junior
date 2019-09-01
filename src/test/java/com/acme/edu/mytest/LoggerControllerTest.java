//package com.acme.edu.mytest;
//
//import com.acme.edu.LoggerController;
//import com.acme.edu.commands.Command;
//import com.acme.edu.savers.ConsoleSaver;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.verify;
//
//public class LoggerControllerTest {
//    private LoggerController sut;
//
//    @Before
//    public void before() {
//        sut = new LoggerController(new ConsoleSaver());
//    }
//
//    @Test
//    public void shouldTypeEqualsReturnTrueIfTypesAreEqual() {
//        Command firstStubCommand = mock(Command.class);
//        Command secondStubCommand = mock(Command.class);
//
//        when(firstStubCommand.isTypeEquals(null)).thenReturn(false);
//        when(secondStubCommand.isTypeEquals(firstStubCommand)).thenReturn(true);
//
//        sut.submit(firstStubCommand);
//        sut.submit(secondStubCommand);
//
//        verify(firstStubCommand).isTypeEquals(null);
//        verify(secondStubCommand).isTypeEquals(firstStubCommand);
//    }
//}
