package com.channels.kata;

import com.channels.kata.model.Player;

public class TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame(){
        player1 = new Player("Player1");
        player2 = new Player("Player2");
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
