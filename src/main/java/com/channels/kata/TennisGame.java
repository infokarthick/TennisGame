package com.channels.kata;

import com.channels.kata.model.Player;

public class TennisGame {

    private static final String[] score = {"Love", "Fifteen", "Thirty", "Forty"};
    private static final int WINNING_MARGIN_POINT = 3;
    private static final char HYPHEN = '-';
    private static final String HYPHEN_ALL = HYPHEN + "All";
    private static final String DEUCE = "Deuce";

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
        } else {
            gameScore = score[player1.getPoint()] + HYPHEN + score[player2.getPoint()];
        }
        return gameScore;
    }

    private boolean isWinningMarginPointScored() {
        return player1.getPoint() >= WINNING_MARGIN_POINT;
    }
}
