package com.kata.tdd;

import com.kata.tdd.model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TennisGameTest {

    private TennisGame tennisGame;

    @BeforeEach
    public void initializeBeforeEachMethod(){
        tennisGame = new TennisGame();
    }

    @Test
    @DisplayName("Tennis Game should have possibility to initialize the player with default names as Player1, Player2")
    public void whenTheGameStartsTennisGameShouldHaveTwoPlayersInitializedWithDefaultNameTest() {
        Assertions.assertEquals("Player1", tennisGame.getPlayerOne().getName());
        Assertions.assertEquals("Player2", tennisGame.getPlayerTwo().getName());
    }

    @Test
    @DisplayName("Tennis Game should have possibility to initialize the player with customer names")
    public void whenTheGameStartsTennisGameShouldHavePossibilityToRegisterCustomNameForTwoPlayersTest() {
        tennisGame = new TennisGame("Tom", "John");
        Assertions.assertEquals("Tom", tennisGame.getPlayerOne().getName());
        Assertions.assertEquals("John", tennisGame.getPlayerTwo().getName());
    }

    @Test
    @DisplayName("At the start of the Tennis Game each player should have zero points ")
    public void whenTheGameStartsEachPlayerShouldBeInitializedWithZeroPointTest() {
        Assertions.assertEquals(0, tennisGame.getPlayerOne().getPoint());
        Assertions.assertEquals(0, tennisGame.getPlayerTwo().getPoint());
    }

    @Test
    @DisplayName("Score should be Love-All At the beginning of the Tennis game")
    public void whenTheGameStartsGameScoreShouldBeLoveAllTest() {
        assertEquals("Love-All", tennisGame.calculateGameScore());
    }

    @Test
    @DisplayName("When the Player1 score one point then game score should be equal to Fifteen-Love")
    public void whenPlayer1WinsOneServiceThenGameStatusShouldBeEqualToFifteenLoveTest() {
        tennisGame.getPlayerOne().scorePoint();

        assertEquals("Fifteen-Love", tennisGame.calculateGameScore());
    }

    @Test
    @DisplayName("When the Player2 score two point then game score should be equal to Love-Thirty")
    public void whenPlayer2WinsTwoServicesThenGameStatusShouldBeEqualToLoveThirtyTest() {
        serviceWinByPlayer(tennisGame.getPlayerTwo(), 2);

        assertEquals("Love-Thirty", tennisGame.calculateGameScore());
    }

    @Test
    @DisplayName("When the Player1 wins three services and Player2 score wins two services then game score should be equal to Forty-Thirty")
    public void whenPlayer1WinsThreeServicesAndPlayer2WinsTwoServicesThenGameStatusShouldBeEqualToFortyThirtyTest() {
        serviceWinByPlayer(tennisGame.getPlayerOne(), 3);
        serviceWinByPlayer(tennisGame.getPlayerTwo(), 2);

        assertEquals("Forty-Thirty", tennisGame.calculateGameScore());
    }

    @ParameterizedTest
    @CsvSource({"1,0,Fifteen-Love", "0,1,Love-Fifteen", "1,1,Fifteen-All", "1,2,Fifteen-Thirty",
            "2,1,Thirty-Fifteen", "1,3,Fifteen-Forty", "2,3,Thirty-Forty", "3,2,Forty-Thirty", "2,2,Thirty-All"})
    @DisplayName("The running score of each game is described in a manner peculiar to tennis:" +
            " scores from zero to three points are described as “love”, “fifteen”, “thirty”, and “forty” respectively")
    public void runningScoreShouldBeDescribedInAMannerPeculiarToTennis(int player1Points, int player2Points, String gameScore) {
        serviceWinByPlayer(tennisGame.getPlayerOne(), player1Points);
        serviceWinByPlayer(tennisGame.getPlayerTwo(), player2Points);

        assertEquals(gameScore, tennisGame.calculateGameScore());
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 7, 9, 10})
    @DisplayName("If at least three points have been scored by each player, and the scores are equal, the score is Deuce")
    public void whenAtLeastThreePointsScoredByEachPlayerAndScoresAreEqualThenGameScoreShouldBeEqualToDeuce(int points) {
        serviceWinByPlayer(tennisGame.getPlayerOne(), points);
        serviceWinByPlayer(tennisGame.getPlayerTwo(), points);

        assertEquals("Deuce", tennisGame.calculateGameScore());
    }


    @ParameterizedTest
    @CsvSource({"4,0,Player1 won the match", "4,2,Player1 won the match", "6,4,Player1 won the match",
            "10,8,Player1 won the match", "0,4,Player2 won the match", "1,4,Player2 won the match",
            "3,5,Player2 won the match", "6,8,Player2 won the match", "9,11,Player2 won the match"})
    @DisplayName("A game is Won by a player to have won at least four points in total and at least two points more than the opponent")
    public void whenAPlayerScoresMinimumFourPointsInTotalAndMinimumTwoPointsMoreThanTheOpponentThenGameIsWonByThatPlayer(int player1Points, int player2Points, String gameScore) {
        serviceWinByPlayer(tennisGame.getPlayerOne(), player1Points);
        serviceWinByPlayer(tennisGame.getPlayerTwo(), player2Points);

        assertEquals(gameScore, tennisGame.calculateGameScore());
    }

    @ParameterizedTest
    @CsvSource({"4,3,Player1 has advantage", "5,4,Player1 has advantage", "7,6,Player1 has advantage", "3,4,Player2 has advantage", "9,10,Player2 has advantage"})
    @DisplayName("If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is “advantage” for the player in the lead.")
    public void whenAtleastThreePointsScoredByEachPlayerAndPointDifferenceIsOneThenGameIsAdvantageForThePlayerInLead(int player1Points, int player2Points, String gameScore) {
        serviceWinByPlayer(tennisGame.getPlayerOne(), player1Points);
        serviceWinByPlayer(tennisGame.getPlayerTwo(), player2Points);

        assertEquals(gameScore, tennisGame.calculateGameScore());
    }

    @Test
    @DisplayName("If the winning indicator is one then PlayerOne point should be incremented by one")
    public void whenTheWinningIndicatorIsOneThenPlayer1PointShouldBeIncrementByOne() {
        serviceWinByPlayer(tennisGame.getPlayerOne(), 2);
        serviceWinByPlayer(tennisGame.getPlayerTwo(), 1);
        int playerOnePreviousPoint = tennisGame.getPlayerOne().getPoint();

        tennisGame.addCurrentServicePointToWinner(1);

        assertEquals(playerOnePreviousPoint + 1, tennisGame.getPlayerOne().getPoint());
    }

    @Test
    @DisplayName("If the winning indicator is two then PlayerTwo point should be incremented by one")
    public void whenTheWinningIndicatorIsTwoThenPlayer1PointShouldBeIncrementByOne() {
        serviceWinByPlayer(tennisGame.getPlayerOne(), 2);
        serviceWinByPlayer(tennisGame.getPlayerTwo(), 1);
        int playerTwoPreviousPoint = tennisGame.getPlayerTwo().getPoint();

        tennisGame.addCurrentServicePointToWinner(2);

        assertEquals(playerTwoPreviousPoint + 1, tennisGame.getPlayerTwo().getPoint());
    }

    @Test
    @DisplayName("If the winning indicator is other than one and two then throw IllegalArgumentException")
    public void whenTheWinningIndicatorIsWrongThenThrowIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> {
            tennisGame.addCurrentServicePointToWinner(4);
        });
    }

    @Test
    @DisplayName("If the winning indicator is one and Game score is Thirty-All then new game score should be equal to Forty-Thirty")
    public void whenTheWinningIndicatorIsOneAndGameScoreIsThirtyAllThenNewGameScoreShouldBeFortyThirty() {
        serviceWinByPlayer(tennisGame.getPlayerOne(), 2);
        serviceWinByPlayer(tennisGame.getPlayerTwo(), 2);

        assertEquals("Forty-Thirty", tennisGame.gameScore(1));
    }

    @Test
    @DisplayName("If the winning indicator is two and Game score is Thirty-All then new game score should be equal to Thirty-Forty")
    public void whenTheWinningIndicatorIsTwoAndGameScoreIsThirtyAllThenNewGameScoreShouldBeThirtyForty() {
        serviceWinByPlayer(tennisGame.getPlayerOne(), 2);
        serviceWinByPlayer(tennisGame.getPlayerTwo(), 2);

        assertEquals("Thirty-Forty", tennisGame.gameScore(2));
    }


    private void serviceWinByPlayer(Player player, int numberOfWins) {
        for (int i = 0; i < numberOfWins; i++) {
            player.scorePoint();
        }
    }

}
