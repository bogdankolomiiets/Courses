package com.bogdan.kolomiiets.tasks.Task_09_Game21;

import java.util.ArrayList;
import java.util.List;

public class Computer implements Gamers {
    private boolean banker;
    private int gamerNo;
    private int moneyCount;
    private int score;
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

    @Override
    public void addCard(PlayingCards card) {
        playingCards.add(card);
    }

    @Override
    public List<PlayingCards> getPlayingCards() {
        return playingCards;
    }

    @Override
    public void setMoneyCount(int moneyCount) {
        this.moneyCount = moneyCount;
    }

    @Override
    public int getMoneyCount() {
        return moneyCount;
    }

    @Override
    public void setScore(int score) {
        this.score += score;
    }

    @Override
    public void resetScore() {
        score = 0;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "gamer " + gamerNo;
    }
}
