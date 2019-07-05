package com.kata.tdd.main;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisApplicationTest {

    @Test
    @DisplayName("At the beginning of the game, Tennis Application should print the welcome message in the console")
    public void startOfTennisApplicationShouldPrintTheWelcomeMessageInConsoleTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        TennisApplication.main(new String[] {});

        assertEquals("Welcome!! Are you ready to play Tennis!\r\n", outputStream.toString());
    }
}
