package com.channels.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TennisGameTest {

    @Test
    public void eachTennisGameShouldHaveTwoPlayersInitializedWithDefaultNameTest(){
        TennisGame tennisGame = new TennisGame();
        assertNotNull(tennisGame);
        assertNotNull(tennisGame.getPlayer1());
        assertNotNull(tennisGame.getPlayer2());
        assertEquals("Player1",tennisGame.getPlayer1().getName());
        assertEquals("Player2",tennisGame.getPlayer2().getName());
    }

}
