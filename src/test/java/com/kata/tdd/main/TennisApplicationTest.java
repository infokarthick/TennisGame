package com.kata.tdd.main;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisApplicationTest {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String PLAYER_ONE_NAME = "Tom";

    private ByteArrayOutputStream outputStream;
    private StringBuilder expectedValueBuilder;

    @BeforeEach
    public void initializeBeforeEachMethod(){
        expectedValueBuilder = new StringBuilder("Welcome!! Are you ready to play Tennis! ");
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        System.setIn(new ByteArrayInputStream(PLAYER_ONE_NAME.getBytes()));
    }

    @AfterAll
    public static void resetSystemInAndOut(){
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    @DisplayName("At the beginning of the game, Tennis Application should print the welcome message in the console")
    public void startOfTennisApplicationShouldPrintTheWelcomeMessageInConsoleTest(){

        TennisApplication.main(new String[] {});

        String[] outputStreamArray = outputStream.toString().split(NEW_LINE);
        assertEquals("Welcome!! Are you ready to play Tennis! ", outputStreamArray[0]);
    }

    @Test
    @DisplayName("Tennis Application should ask the user to enter player name and print it in the console")
    public void tennisApplicationShouldAskUserToEnterPlayerNameAndDisplayItInTheConsoleTest(){
        expectedValueBuilder.append(NEW_LINE).append("Please enter the player1 name")
                .append(NEW_LINE).append(PLAYER_ONE_NAME).append(NEW_LINE);

        TennisApplication.main(new String[] {});

        assertEquals(expectedValueBuilder.toString(), outputStream.toString());
    }
}
