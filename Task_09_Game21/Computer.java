package com.bogdan.kolomiiets.tasks.Task_09_Game21;

public class Computer implements Gamers {
    private boolean banker;
    private int gamerNo;
    private int moneyCount;

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
    public String toString() {
        return "Computer{" +
                "banker=" + banker +
                ", gamerNo=" + gamerNo +
                '}';
    }
}
