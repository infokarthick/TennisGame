package com.kata.tdd;

import com.kata.tdd.model.Player;

public class TennisGame {

    private static final int MINIMUM_WINNING_SCORE = 4;
    private static final int ADVANTAGE_DIFFERENCE_POINT = 1;
    private static final int MINIMUM_DEUCE_POINT = 3;

    private static final char HYPHEN = '-';
    private static final String WON_THE_MATCH = " won the match";
    private static final String HAS_ADVANTAGE = " has advantage";
    private static final String HYPHEN_ALL = HYPHEN + "All";
    private static final String DEUCE = "Deuce";
    private static final String PLAYER_ONE_DEFAULT_NAME = "Player1";
    private static final String PLAYER_TWO_DEFAULT_NAME = "Player2";
    private static final int PLAYER_ONE_WINNING_INDICATOR = 1;
    private static final int PLAYER_TWO_WINNING_INDICATOR = 2;

    private static final String[] score = {"Love", "Fifteen", "Thirty", "Forty"};

    private Player playerOne;
    private Player playerTwo;
    private String gameScore;

    public TennisGame(){
        this(PLAYER_ONE_DEFAULT_NAME, PLAYER_TWO_DEFAULT_NAME);
    }

    public TennisGame(String player1Name, String player2Name) {
        playerOne = new Player(player1Name);
        playerTwo = new Player(player2Name);
        gameScore = getConcatenatedString(score[0], HYPHEN_ALL);
    }

    protected Player getPlayerOne() {
        return playerOne;
    }

    protected Player getPlayerTwo() {
        return playerTwo;
    }

    public String calculateGameScore() {
        if (isScoredPointsAreEqual()) {
            gameScore = isMinimumDeucePointsScored() ? DEUCE : getConcatenatedString(score[playerOne.getPoint()], HYPHEN_ALL);
        } else if (isAnyPlayerEligibleToWin()) {
            gameScore = isPointsDifferenceEqualToOne() ? getEligibleWinningPlayerScore(HAS_ADVANTAGE) : getEligibleWinningPlayerScore(WON_THE_MATCH);
        } else {
            gameScore = score[playerOne.getPoint()] + HYPHEN + score[playerTwo.getPoint()];
        }
        return gameScore;
    }

    private String getConcatenatedString(String topScorerName, String hasAdvantage) {
        return topScorerName + hasAdvantage;
    }

    private String getEligibleWinningPlayerScore(String eligibleWinnerScore) {
        return getConcatenatedString(getTopScorerName(), eligibleWinnerScore);
    }

    private boolean isScoredPointsAreEqual() {
        return playerOne.getPoint() == playerTwo.getPoint();
    }

    private boolean isPointsDifferenceEqualToOne() {
        return Math.abs(playerOne.getPoint() - playerTwo.getPoint()) == ADVANTAGE_DIFFERENCE_POINT;
    }

    private boolean isAnyPlayerEligibleToWin() {
        return playerOne.getPoint() >= MINIMUM_WINNING_SCORE || playerTwo.getPoint() >= MINIMUM_WINNING_SCORE;
    }

    private boolean isMinimumDeucePointsScored() {
        return playerOne.getPoint() >= MINIMUM_DEUCE_POINT;
    }

    private String getTopScorerName() {
        return playerOne.getPoint() > playerTwo.getPoint() ? playerOne.getName() : playerTwo.getName();
    }

    protected void addCurrentServicePointToWinner(int winningIndicator) {
        if (PLAYER_ONE_WINNING_INDICATOR == winningIndicator) {
            playerOne.scorePoint();
        } else if (PLAYER_TWO_WINNING_INDICATOR == winningIndicator) {
            playerTwo.scorePoint();
        } else {
            throw new IllegalArgumentException("Winning indicator should be either 1 or 2");
        }
    }

    protected String gameScore(int winningIndicator) {
        addCurrentServicePointToWinner(winningIndicator);
        return calculateGameScore();
    }
}
