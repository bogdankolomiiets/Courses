package com.bogdan.kolomiiets.tasks.Task_09_Game21;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

=======
>>>>>>> 2e3fe7bc6940b330e17c11dcf05b13f088c1be90
public class Computer implements Gamers {
    private boolean banker;
    private int gamerNo;
    private int moneyCount;
<<<<<<< HEAD
    private List<PlayingCards> playingCards = new ArrayList<>();
=======
>>>>>>> 2e3fe7bc6940b330e17c11dcf05b13f088c1be90

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
<<<<<<< HEAD
    public void setOneCard(PlayingCards card) {
        playingCards.add(card);
    }

    @Override
    public String toString() {
        return "gamer: " + gamerNo;
=======
    public String toString() {
        return "Computer{" +
                "banker=" + banker +
                ", gamerNo=" + gamerNo +
                '}';
>>>>>>> 2e3fe7bc6940b330e17c11dcf05b13f088c1be90
    }
}
