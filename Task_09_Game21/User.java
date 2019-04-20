package com.bogdan.kolomiiets.tasks.Task_09_Game21;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public class User implements Gamers {
    private boolean banker;
    private int moneyCount;
    private List<PlayingCards> playingCards = new ArrayList<>();

=======
public class User implements Gamers {
    private boolean banker;
    private int moneyCount;
>>>>>>> 2e3fe7bc6940b330e17c11dcf05b13f088c1be90

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
        System.out.println("You have got card: " + card);
    }

    @Override
    public String toString() {
        return "YOU";
=======
    public String toString() {
        return "User{" +
                "banker=" + banker +
                '}';
>>>>>>> 2e3fe7bc6940b330e17c11dcf05b13f088c1be90
    }
}
