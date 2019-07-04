package com.channels.kata;

import com.channels.kata.model.Player;

public class TennisGame {

    private static final int MINIMUM_WINNING_SCORE = 4;
    private static final int ADVANTAGE_DIFFERENCE_POINT = 1;
    private static final int MINIMUM_DEUCE_POINT = 3;

    private static final char HYPHEN = '-';
    private static final String WON_THE_MATCH = " won the match";
    private static final String HYPHEN_ALL = HYPHEN + "All";
    private static final String DEUCE = "Deuce";

    private static final String[] score = {"Love", "Fifteen", "Thirty", "Forty"};

    private Player player1;
    private Player player2;
    private String gameScore;

    public TennisGame(){
        this("Player1", "Player2");
    }

    public TennisGame(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        gameScore = score[0] + HYPHEN_ALL;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public String getGameScore() {
        if (player1.getPoint() == player2.getPoint()) {
            if (isWinningMarginPointScored()) {
                gameScore = DEUCE;
            } else {
                gameScore = score[player1.getPoint()] + HYPHEN_ALL;
            }
        } else if (isAnyPlayerEligibleToWin()) {
            if (isPointsDifferenceEqualToOne()) {
                gameScore = getTopScorerName() + " has advantage";
            } else {
                gameScore = getTopScorerName() + WON_THE_MATCH;
            }
        } else {
            gameScore = score[player1.getPoint()] + HYPHEN + score[player2.getPoint()];
        }
        return gameScore;
    }

    private boolean isPointsDifferenceEqualToOne() {
        return Math.abs(player1.getPoint() - player2.getPoint()) == ADVANTAGE_DIFFERENCE_POINT;
    }

    private boolean isAnyPlayerEligibleToWin() {
        return player1.getPoint() >= MINIMUM_WINNING_SCORE || player2.getPoint() >= MINIMUM_WINNING_SCORE;
    }

    private boolean isWinningMarginPointScored() {
        return player1.getPoint() >= MINIMUM_DEUCE_POINT;
    }

    private String getTopScorerName() {
        return player1.getPoint() > player2.getPoint() ? player1.getName() : player2.getName();
    }

}
