package com.bogdan.kolomiiets.tasks.Task_09_Game21;

import java.util.ArrayList;
import java.util.List;

public class Computer implements Gamers {
    private boolean banker;

    public int getGamerNo() {
        return gamerNo;
    }

    private int gamerNo;
    private int moneyCount;
    private List<PlayingCards> playingCards = new ArrayList<>();

    public Computer(int gamerNo) {
        this.gamerNo = gamerNo;
    }

    @Override
    public boolean isBanker() {
        return banker;
    }

    @Override
    public void setBanker(boolean banker) {
        this.banker = banker;
    }

    public void getOneCard(PlayingCards card) {
        playingCards.add(card);
    }

    @Override
    public String toString() {
        return "gamer " + gamerNo;
    }
}
