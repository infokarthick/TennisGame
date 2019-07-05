package com.kata.tdd.main;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisApplicationTest {

    @Test
    @DisplayName("At the beginning of the game, Tennis Application should print the welcome message in the console")
    public void startOfTennisApplicationShouldPrintTheWelcomeMessageInConsoleTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String playerName = "Tom";
        System.setIn(new ByteArrayInputStream(playerName.getBytes()));

        TennisApplication.main(new String[] {});

        String[] outputStreamArray = outputStream.toString().split("\r\n");
        assertEquals("Welcome!! Are you ready to play Tennis! ", outputStreamArray[0]);
    }

    @Test
    @DisplayName("Tennis Application should ask the user to enter player name and print it in the console")
    public void tennisApplicationShouldAskUserToEnterPlayerNameAndDisplayItInTheConsoleTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String playerName = "Tom";
        System.setIn(new ByteArrayInputStream(playerName.getBytes()));

        StringBuilder expectedValueBuilder = new StringBuilder("Welcome!! Are you ready to play Tennis! \r\nPlease enter the player1 name\r\n")
                .append(playerName).append("\r\n");

        TennisApplication.main(new String[] {});

        assertEquals(expectedValueBuilder.toString(), outputStream.toString());
    }
}
