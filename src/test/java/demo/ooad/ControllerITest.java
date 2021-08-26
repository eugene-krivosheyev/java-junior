package demo.ooad;


import demo.ooad.controller.LoggerController;
import demo.ooad.dao.ConsoleSaver;
import demo.ooad.domain.Message;
import demo.ooad.domain.SeverityLevel;
import demo.ooad.filter.LengthFilter;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class, Test Case, Test Suite
 * SUT
 */
public class ControllerITest {
    /**
     * Test, Scenario:
     * - pre-conditions: system state + input values
     * - post-conditions: system state + output values
     */
    @Test
    public void shouldGetErrorWhenMessageBodyNotExists() {
        //region Fixture | Arrange | Given
        LoggerController controllerSut = new LoggerController(
                new LengthFilter(1),
                new ConsoleSaver()
        );
        Message bodilessMessage = new Message(null, SeverityLevel.WARN);
        //endregion

        //region Act + Assert | When + Then
        assertThrows(
            IllegalArgumentException.class,
            () -> controllerSut.log(bodilessMessage)
        );
        //endregion
    }

    @Test //@DisplayName
    @Disabled
    public void shouldSaveWhenMessageWithValidLength() {
        //Given
        Message validMessage = new Message("message body with valid length", SeverityLevel.ERROR);
        LoggerController sutController = new LoggerController(
                new LengthFilter(100),
                new ConsoleSaver()
        );

        //When
        sutController.log(validMessage);

        //Then

    }
}
