package com.kata.tdd.main;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisApplicationTest {

    @Test
    @DisplayName("System Out should print 'Welcome Message' in the Console")
    public void systemOutShouldPrintWelcomeMessageInConsoleTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        System.out.println("Welcome message");

        assertEquals("Welcome message\r\n", outputStream.toString());
    }
}
