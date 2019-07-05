package com.kata.tdd.main;

import java.util.Scanner;

public class TennisApplication {

    public static void main(String[] args) {
        System.out.println("Welcome!! Are you ready to play Tennis! \r\nPlease enter the player1 name");
        Scanner inputScanner = new Scanner(System.in);

        String playerOneName = inputScanner.nextLine();
        System.out.println(playerOneName);
    }
}
