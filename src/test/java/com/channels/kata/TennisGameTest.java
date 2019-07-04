package com.channels.kata;

import com.channels.kata.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    public void tennisGameShouldHavePossibilityToRegisterCustomNameForTwoPlayersTest() {
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
    public void whenPlayer1WinsOneServiceThenGameStatusShouldBeEqualToFifteenLoveTest() {
        tennisGame.getPlayer1().scorePoint();

        assertEquals("Fifteen-Love", tennisGame.getGameScore());
    }

    @Test
    @DisplayName("When the Player2 score two point then game score should be equal to Love-Thirty")
    public void whenPlayer2WinsTwoServicesThenGameStatusShouldBeEqualToLoveThirtyTest() {
        serviceWinByPlayer(tennisGame.getPlayer2(), 2);

        assertEquals("Love-Thirty", tennisGame.getGameScore());
    }

    @Test
    @DisplayName("When the Player1 wins three services and Player2 score wins two services then game score should be equal to Forty-Thirty")
    public void whenPlayer1WinsThreeServicesAndPlayer2WinsTwoServicesThenGameStatusShouldBeEqualToFortyThirtyTest() {
        serviceWinByPlayer(tennisGame.getPlayer1(), 3);
        serviceWinByPlayer(tennisGame.getPlayer2(), 2);

        assertEquals("Forty-Thirty", tennisGame.getGameScore());
    }

    @ParameterizedTest
    @CsvSource({"1,0,Fifteen-Love", "0,1,Love-Fifteen", "1,1,Fifteen-All", "1,2,Fifteen-Thirty",
            "2,1,Thirty-Fifteen", "1,3,Fifteen-Forty", "2,3,Thirty-Forty", "3,2,Forty-Thirty", "2,2,Thirty-All"})
    @DisplayName("The running score of each game is described in a manner peculiar to tennis:" +
            " scores from zero to three points are described as “love”, “fifteen”, “thirty”, and “forty” respectively")
    public void runningScoreShouldBeDescribedInAMannerPeculiarToTennis(int player1Points, int player2Points, String gameScore) {
        serviceWinByPlayer(tennisGame.getPlayer1(), player1Points);
        serviceWinByPlayer(tennisGame.getPlayer2(), player2Points);

        assertEquals(gameScore, tennisGame.getGameScore());
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 7, 9, 10})
    @DisplayName("If at least three points have been scored by each player, and the scores are equal, the score is Deuce")
    public void WhenAtLeastThreePointsScoredByEachPlayerAndScoresAreEqualThenGameScoreShouldBeEqualToDeuce(int points) {
        serviceWinByPlayer(tennisGame.getPlayer1(), points);
        serviceWinByPlayer(tennisGame.getPlayer2(), points);

        assertEquals("Deuce", tennisGame.getGameScore());
    }


    @ParameterizedTest
    @CsvSource({"4,0,Player1 won the match", "4,2,Player1 won the match", "6,4,Player1 won the match",
            "10,8,Player1 won the match", "0,4,Player2 won the match", "1,4,Player2 won the match",
            "3,5,Player2 won the match", "6,8,Player2 won the match", "9,11,Player2 won the match"})
    @DisplayName("A game is Won by a player to have won at least four points in total and at least two points more than the opponent")
    public void gameIsWonByPlayerToHaveMinimumFourPointsInTotalAndMinimumTwoPointsMoreThanTheOpponent(int player1Points, int player2Points, String gameScore) {
        serviceWinByPlayer(tennisGame.getPlayer1(), player1Points);
        serviceWinByPlayer(tennisGame.getPlayer2(), player2Points);

        assertEquals(gameScore, tennisGame.getGameScore());
    }

    @ParameterizedTest
    @CsvSource({"4,3,Player1 has advantage"})
    @DisplayName("If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is “advantage” for the player in the lead.")
    public void whenAtleastThreePointsScoredByEachPlayerAndPointDifferenceIsOneThenGameIsAdvantageForThePlayerInLead(int player1Points, int player2Points, String gameScore) {
        serviceWinByPlayer(tennisGame.getPlayer1(), player1Points);
        serviceWinByPlayer(tennisGame.getPlayer2(), player2Points);

        assertEquals(gameScore, tennisGame.getGameScore());
    }

    private void serviceWinByPlayer(Player player, int numberOfWins) {
        for (int i = 0; i < numberOfWins; i++) {
            player.scorePoint();
        }
    }

}
