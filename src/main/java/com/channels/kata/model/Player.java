package com.channels.kata.model;

public class Player {

    private String name;

    private int point;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void scorePoint(){
        point++;
    }
}
