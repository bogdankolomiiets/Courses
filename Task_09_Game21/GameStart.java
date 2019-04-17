package com.bogdan.kolomiiets.tasks.Task_09_Game21;

import java.util.ArrayList;
import java.util.List;

public class GameStart {

    private CardDeck deck;
    private int gamersCount;
    List<Gamers> gamers = new ArrayList<>();

    public GameStart(CardDeck deck, int gamersCount) {
        this.deck = deck;
        this.gamersCount = gamersCount;

        initUser();
        //init another gamers
        initAnotherGamers();
        //choose a banker
        setRandBanker();
    }

    private void initUser(){
        User user = new User();
        gamers.add(user);
        gamersCount--;
    }

    private void initAnotherGamers(){
        for (int i = 0; i < gamersCount; i++){
            gamers.add(new Computer(i+1));
        }
    }

    private void setRandBanker(){
        gamers.get((int) (Math.random() * gamers.size())).setBanker(true);
    }
}
