package com.channels.kata;

import com.channels.kata.model.Player;

public class TennisGame {

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
        return gameScore;
    }
}
