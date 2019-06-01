package com.bogdan.kolomiiets.tasks.Task_09_Game21;

import java.util.List;

public interface Gamers {
    boolean isBanker();
    int getMoneyCount();
    int getScore();
    void setMoneyCount(int moneyCount);
    void setScore(int score);
    void resetScore();
    void setBanker(boolean banker);
    void addCard(PlayingCards cards);
    List<PlayingCards> getPlayingCards();
}
