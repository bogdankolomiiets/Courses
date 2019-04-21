package com.bogdan.kolomiiets.tasks.Task_09_Game21;

import java.util.ArrayList;
import java.util.List;

public class User implements Gamers {
    private boolean banker;
    private int moneyCount;
    private List<PlayingCards> playingCards = new ArrayList<>();

    @Override
    public boolean isBanker() {
        return banker;
    }

    @Override
    public void setBanker(boolean banker) {
        this.banker = banker;
    }

    @Override
    public void getOneCard(PlayingCards card) {
        playingCards.add(card);
        System.out.println("You have got card: " + card);
    }

    @Override
    public int getGamerNo() {
        return 1;
    }

    @Override
    public String toString() {
        return "YOU";
    }
}
