package com.kata.tdd.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    @DisplayName("When Player score point then player point should be increment by 1")
    public void whenPlayerScorePointThenPlayerPointShouldBeIncrementedByOne(){
        Player player = new Player("Tom");
        player.scorePoint();

        assertEquals(1, player.getPoint());
    }

}
