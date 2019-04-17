package com.bogdan.kolomiiets.tasks.Task_09_Game21;

public class User implements Gamers {
    private boolean banker;
    private int moneyCount;

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
        return "User{" +
                "banker=" + banker +
                '}';
    }
}
