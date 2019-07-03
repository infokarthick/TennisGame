package com.channels.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameTest {

    private TennisGame tennisGame;

    @BeforeEach
    public void initializeBeforeEachMethod(){
        tennisGame = new TennisGame();
    }

    @Test
    @DisplayName("Tennis Game should have possibility to initialize the player with default names as Player1, Player2")
    public void eachTennisGameShouldHaveTwoPlayersInitializedWithDefaultNameTest(){
        assertEquals("Player1",tennisGame.getPlayer1().getName());
        assertEquals("Player2",tennisGame.getPlayer2().getName());
    }

    @Test
    @DisplayName("Tennis Game should have possibility to initialize the player with customer names")
    public void tennisGameShouldHavePosibilityToRegisterCustomNameForTwoPlayersTest(){
        tennisGame = new TennisGame("Tom", "John");
        assertEquals("Tom",tennisGame.getPlayer1().getName());
        assertEquals("John",tennisGame.getPlayer2().getName());
    }

    @Test
    @DisplayName("At the start of the Tennis Game each player should have zero points ")
    public void atTheStartOfTheGameEachPlayerShouldBeInitializedWithZeroPointTest(){
        assertEquals(0,tennisGame.getPlayer1().getPoint());
        assertEquals(0,tennisGame.getPlayer2().getPoint());
    }

    @Test
    @DisplayName("Score should be Love-All At the beginning of the Tennis game")
    public void statusOfTheTennisGameShouldBeLoveAllAtTheBeginnningTest(){
        assertEquals("Love-All", tennisGame.getGameScore());
    }

    @Test
    @DisplayName("When the Player1 score one point then game score should be equal to Fifteen-Love")
    public void whenPlayer1ScorePointThenPlayer1PointshouldBeIncrementByOnePoint() {
        tennisGame.getPlayer1().scorePoint();

        assertEquals("Fifteen-Love", tennisGame.getGameScore());
    }

}
