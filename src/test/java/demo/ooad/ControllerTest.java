package demo.ooad;


import demo.ooad.controller.LoggerController;
import demo.ooad.dao.ConsoleSaver;
import demo.ooad.dao.Saver;
import demo.ooad.domain.Message;
import demo.ooad.domain.SeverityLevel;
import demo.ooad.filter.Filter;
import demo.ooad.filter.LengthFilter;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Test class, Test Case, Test Suite
 * SUT
 */
public class ControllerTest {
    /**
     * Test, Scenario:
     * - pre-conditions: system state + input values
     * - post-conditions: system state + output values
     */


    @Test
    public void shouldGetErrorWhenMessageBodyNotExists() {
        //region Fixture | Arrange | Given
        Filter filterDummy = mock(Filter.class);
        Saver saveDummy = mock(Saver.class);
        LoggerController controllerSut = new LoggerController(filterDummy, saveDummy);

        Message bodilessMessage = mock(Message.class);
        when(bodilessMessage.getBody()).thenReturn(null);
        //endregion

        //region Act + Assert | When + Then
        assertThrows(
            IllegalArgumentException.class,
            () -> controllerSut.log(bodilessMessage)
        );

        /*
        assertThat(sut, //hamcrest
                allOf(
                        isNotNull(),
                        hasProperty("p", 4),
                        containsOnly(2,3,4,5)
                        hasElement("ffff", hasValue())
                )
        );

        assertThat(sut).hasElemnt().notEmpty().notNull(); //assert-j
         */
        //endregion
    }

    @Test //@DisplayName //@Disabled
    public void shouldSaveWhenMessageNotFiltered() {
        //Given
        Saver saverMock = mock(Saver.class);
        Filter filterStub = mock(Filter.class);
        when(filterStub.filter(any(Message.class))).thenReturn(false);

        LoggerController sutController = new LoggerController(filterStub, saverMock);

        //When
        Message messageStub = mock(Message.class);
        when(messageStub.getBody()).thenReturn("stub body");
        sutController.log(messageStub);

        //Then
        verify(saverMock, times(1)).save(any());
    }

    @Test
    public void stubShouldHoldState() {
        Object stubObject = mock(Object.class);
        when(stubObject.toString())
                .thenReturn("1")
                .thenReturn("2")
                .thenReturn("3");

        assertEquals("1", stubObject.toString());
        assertEquals("2", stubObject.toString());
        assertEquals("3", stubObject.toString());

//        verify(mock, times(1)).write(anyString());
    }
}
