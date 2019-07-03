package com.channels.kata;

import com.channels.kata.model.Player;

public class TennisGame {

    private static final String[] score = {"Love", "Fifteen", "Thirty"};

    private Player player1;
    private Player player2;
    private String gameScore;

    public TennisGame(){
        this("Player1", "Player2");
    }

    public TennisGame(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        gameScore = "Love-All";
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public String getGameScore() {
        if (player1.getPoint() == player2.getPoint()) {
            gameScore = score[player1.getPoint()] + "-All";
        } else {
            gameScore = score[player1.getPoint()] + "-" + score[player2.getPoint()];
        }
        return gameScore;
    }
}
