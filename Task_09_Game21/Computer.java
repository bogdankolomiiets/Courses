package com.bogdan.kolomiiets.tasks.Task_09_Game21;

public class Computer implements Gamers {
    private boolean isBanker;
    private int gamerNo;

    public Computer(int gamerNo) {
        this.gamerNo = gamerNo;
    }

    public boolean isBanker() {
        return isBanker;
    }

    public void setBanker(boolean banker) {
        isBanker = banker;
    }
}
